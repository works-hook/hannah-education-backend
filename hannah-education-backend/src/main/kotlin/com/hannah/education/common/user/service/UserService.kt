package com.hannah.education.common.user.service

import com.hannah.education.common.user.dto.request.UserCreateRequest
import com.hannah.education.common.user.dto.request.UserDuplicateRequest
import com.hannah.education.common.user.dto.request.UserLoginRequest
import com.hannah.education.common.user.dto.request.UserUpdatePasswordRequest
import com.hannah.education.common.user.dto.response.UserCreateResponse
import com.hannah.education.common.user.dto.response.UserLoginSuccessResponse
import com.hannah.education.common.user.dto.response.toCreateResponseDto
import com.hannah.education.common.user.dto.response.toLoginResponse
import com.hannah.education.config.jwt.JwtTokenProvider
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import io.jsonwebtoken.Claims
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {

    @Transactional
    fun createUser(request: UserCreateRequest): UserCreateResponse {
        val userEntity = request.toEntity()
        userEntity.encodingPassword(passwordEncoder)
        return userRepository.save(userEntity).toCreateResponseDto()
    }

    @Transactional
    fun accountDuplicateCheck(request: UserDuplicateRequest) {
        userRepository.findByAccount(request.account)
            ?.let { throw BusinessException(ErrorCode.EXIST_ACCOUNT) }
    }

    @Transactional
    fun deleteUser(id: Long) {
        val findUser = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        findUser.delete()
    }

    fun loginUser(request: UserLoginRequest): UserLoginSuccessResponse {
        val user = userRepository.findByAccount(request.account)
            ?: throw BusinessException(ErrorCode.NOT_MATCH_MEMBER)
        checkPassword(request.password, user.password)

        val token = jwtTokenProvider.generator(getClaims(user.id))
        return user.toLoginResponse(token)
    }

    @Transactional
    fun updatePassword(id: Long, request: UserUpdatePasswordRequest) {
        val user = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        checkPassword(request.originPassword, user.password)
        user.updatePassword(passwordEncoder.encode(request.updatePassword))
    }

    private fun checkPassword(requestPassword: String, originPassword: String) {
        val checkPassword = passwordEncoder.matches(requestPassword, originPassword)
        if (!checkPassword) throw BusinessException(ErrorCode.NOT_MATCH_PASSWORD)
    }

    private fun getClaims(userId: Long?): Map<String, Long?> {
        return mapOf("userId" to userId)
    }

}