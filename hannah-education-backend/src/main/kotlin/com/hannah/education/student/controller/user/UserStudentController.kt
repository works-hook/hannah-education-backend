package com.hannah.education.student.controller.user

import com.hannah.education.student.dto.request.StudentModifyRequest
import com.hannah.education.student.dto.response.StudentModifyResponse
import com.hannah.education.student.dto.response.StudentOneResponse
import com.hannah.education.student.service.user.UserStudentService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users-student")
class UserStudentController(
    private val userService: UserStudentService,
) {

    @PatchMapping("/{id}")
    fun modifyStudent(
        @PathVariable id: Long,
        @RequestBody request: StudentModifyRequest,
    ): Success<StudentModifyResponse> {
        val result = userService.modifyStudent(id, request)
        return Success(result, SuccessCode.USER_MODIFY)
    }

    @GetMapping("/{id}")
    fun findOneStudent(@PathVariable id: Long): Success<StudentOneResponse> {
        val result = userService.findOneStudent(id)
        return Success(result, SuccessCode.USER_ONE)
    }

}