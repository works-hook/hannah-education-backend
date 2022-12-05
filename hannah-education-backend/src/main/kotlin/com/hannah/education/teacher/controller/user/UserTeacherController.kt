package com.hannah.education.teacher.controller.user

import com.hannah.education.teacher.service.user.UserTeacherService
import com.hannah.education.teacher.dto.request.TeacherModifyRequest
import com.hannah.education.teacher.dto.response.TeacherModifyResponse
import com.hannah.education.teacher.dto.response.TeacherOneResponse
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users-teacher")
class UserTeacherController(
    private val userTeacherService: UserTeacherService,
) {

    @PatchMapping("/{id}")
    fun modifyTeacher(
        @PathVariable id: Long,
        @RequestBody request: TeacherModifyRequest,
    ): Success<TeacherModifyResponse> {
        val result = userTeacherService.modifyTeacher(id, request)
        return Success(result, SuccessCode.USER_MODIFY)
    }

    @GetMapping("/{id}")
    fun findOneTeacher(@PathVariable id: Long): Success<TeacherOneResponse> {
        val result = userTeacherService.findOneTeacher(id)
        return Success(result, SuccessCode.USER_ONE)
    }

}