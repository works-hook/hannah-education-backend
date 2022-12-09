package com.hannah.education.config.interceptor

import com.hannah.education.config.jwt.JwtTokenProvider
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import io.jsonwebtoken.Claims
import mu.KotlinLogging
import org.springframework.stereotype.Component
import java.lang.Long.valueOf
import javax.servlet.http.HttpServletRequest

@Component
class TokenComponent(
    private val jwtTokenProvider: JwtTokenProvider,
    private val userRepository: UserRepository,
) {

    private val logger = KotlinLogging.logger {}

    fun getClaimsCheck(request: HttpServletRequest): Boolean {
        val token = request.getHeader("auth") ?: throw BusinessException(ErrorCode.JWT_ERROR)
        val claims: Claims = jwtTokenProvider.validateJwt(token)
        logger.info("-----------token----------- > {}", token)
        logger.info("-----------userId---------- > {}", claims["userId"])
        return userChecked(request, claims)
    }

    private fun userChecked(request: HttpServletRequest, claims: Claims): Boolean {
        val userId = valueOf(claims["userId"].toString())
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        request.setAttribute("userId", findUser.id)
        return true
    }
}