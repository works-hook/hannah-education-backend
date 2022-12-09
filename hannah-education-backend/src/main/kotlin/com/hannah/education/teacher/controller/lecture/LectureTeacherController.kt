package com.hannah.education.teacher.controller.lecture

import com.hannah.education.config.resolver.UserId
import com.hannah.education.teacher.dto.request.LectureCreateRequest
import com.hannah.education.teacher.dto.request.LectureModifyRequest
import com.hannah.education.teacher.dto.response.LectureListResponse
import com.hannah.education.teacher.dto.response.LectureOneResponse
import com.hannah.education.teacher.service.lecture.LectureTeacherService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture-teacher")
class LectureTeacherController(
    private val teacherService: LectureTeacherService,
) {

    @PostMapping("")
    fun createLecture(@UserId userId: Long, @RequestBody request: LectureCreateRequest): Success<String> {
        teacherService.createLecture(userId, request)
        return Success(SuccessCode.LECTURE_CREATE)
    }

    @PatchMapping("/{lectureId}")
    fun modifyLecture(
        @PathVariable lectureId: Long,
        @RequestBody request: LectureModifyRequest,
    ): Success<LectureOneResponse> {
        val result = teacherService.modifyLecture(lectureId, request)
        return Success(result, SuccessCode.LECTURE_MODIFY)
    }

    @DeleteMapping("/{lectureId}")
    fun deleteLecture(@PathVariable lectureId: Long): Success<String> {
        teacherService.deleteLecture(lectureId)
        return Success(SuccessCode.LECTURE_DELETE)
    }

    @GetMapping("/lecture")
    fun findAllLecture(@UserId userId: Long): Success<List<LectureListResponse>> {
        val result = teacherService.findAllLecture(userId)
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @GetMapping("/student/{lectureId}")
    fun findOneLecture(@PathVariable lectureId: Long): Success<LectureOneResponse> {
        val result = teacherService.findOneLecture(lectureId)
        return Success(result, SuccessCode.ONE_LECTURE)
    }

}