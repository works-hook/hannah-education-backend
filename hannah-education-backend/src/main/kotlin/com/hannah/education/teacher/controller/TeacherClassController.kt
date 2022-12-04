package com.hannah.education.teacher.controller

import com.hannah.education.teacher.dto.request.ClassCreateRequest
import com.hannah.education.teacher.dto.request.ClassModifyRequest
import com.hannah.education.teacher.dto.response.ClassResponse
import com.hannah.education.teacher.service.TeacherClassService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/class-teacher")
class TeacherClassController(
    private val classService: TeacherClassService,
) {

    @PostMapping("/{lectureId}")
    fun createClass(@PathVariable lectureId: Long, @RequestBody request: ClassCreateRequest): Success<String> {
        classService.createClass(lectureId, request)
        return Success(SuccessCode.CLASS_CREATE)
    }

    @PatchMapping("/{classId}")
    fun modifyClass(@PathVariable classId: Long, @RequestBody request: ClassModifyRequest): Success<String> {
        classService.modifyClass(classId, request)
        return Success(SuccessCode.CLASS_MODIFY)
    }

    @DeleteMapping("/{classId}")
    fun deleteClass(@PathVariable classId: Long): Success<String> {
        classService.deleteClass(classId)
        return Success(SuccessCode.CLASS_DELETE)
    }

    @GetMapping("/{lectureId}")
    fun findAllClass(@PathVariable lectureId: Long): Success<List<ClassResponse>> {
        val result = classService.findAllClass(lectureId)
        return Success(result, SuccessCode.ALL_CLASS)
    }
}