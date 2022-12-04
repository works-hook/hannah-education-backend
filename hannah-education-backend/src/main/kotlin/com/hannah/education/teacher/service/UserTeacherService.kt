package com.hannah.education.teacher.service

import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.teacher.dto.request.TeacherModifyRequest
import com.hannah.education.teacher.dto.response.TeacherModifyResponse
import com.hannah.education.teacher.dto.response.TeacherOneResponse
import com.hannah.education.teacher.dto.response.toTeacherModifyResponse
import com.hannah.education.teacher.dto.response.toTeacherOneResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserTeacherService(
    private val userRepository: UserRepository,
) {

    @Transactional
    fun modifyTeacher(id: Long, request: TeacherModifyRequest): TeacherModifyResponse {
        val findUser = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        findUser.teacherUpdate(request)
        return findUser.toTeacherModifyResponse()
    }

    fun findOneTeacher(id: Long): TeacherOneResponse {
        val user = userRepository.findUserById(id)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return user.toTeacherOneResponse()
    }

}