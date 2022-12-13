package com.hannah.education.student.controller.lecture

import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.config.resolver.UserId
import com.hannah.education.domain.lecture.dto.LectureResponse
import com.hannah.education.student.dto.response.LectureDetailResponse
import com.hannah.education.student.dto.response.TeacherDetailResponse
import com.hannah.education.student.service.lecture.LectureService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture-student")
class LectureController(
    private val studentService: LectureService,
) {

    @NoToken
    @GetMapping("/most-taken")
    fun mostTakenLectures(): Success<List<LectureResponse>> {
        val result = studentService.mostTakenLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @NoToken
    @GetMapping("/most-like")
    fun mostLikeLectures(): Success<List<LectureResponse>> {
        val result = studentService.mostLikeLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @NoToken
    @GetMapping("")
    fun findAllLectures(): Success<List<LectureResponse>> {
        val result = studentService.findAllLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @NoToken
    @GetMapping("/{lectureId}")
    fun findOneLecture(@PathVariable lectureId: Long): Success<LectureDetailResponse> {
        val result = studentService.findOneLecture(lectureId)
        return Success(result, SuccessCode.ONE_LECTURE)
    }

    @NoToken
    @GetMapping("/teacher/{lectureId}")
    fun findTeacherById(@PathVariable lectureId: Long): Success<TeacherDetailResponse> {
        val result = studentService.findTeacherByLectureId(lectureId)
        return Success(result, SuccessCode.ONE_TEACHER);
    }

    @PostMapping("/take/{lectureId}")
    fun takeLecture(@PathVariable lectureId: Long, @UserId userId: Long): Success<String> {
        studentService.takeLecture(lectureId, userId)
        return Success(SuccessCode.TAKING_LECTURE)
    }

    @GetMapping("/like/{lectureId}")
    fun checkLikedLecture(@UserId id: Long, @PathVariable lectureId: Long): Success<Boolean> {
        val result = studentService.checkLikedLecture(id, lectureId)
        return Success(result, SuccessCode.LIKE_LECTURE)
    }

    @PostMapping("/like/{lectureId}")
    fun likeLecture(@PathVariable lectureId: Long, @UserId userId: Long): Success<String> {
        studentService.likeLecture(lectureId, userId)
        return Success(SuccessCode.LIKE_LECTURE)
    }

    @DeleteMapping("/like/{lectureId}")
    fun cancelLikeLecture(@PathVariable lectureId: Long, @UserId userId: Long): Success<String> {
        studentService.cancelLikeLecture(lectureId, userId)
        return Success(SuccessCode.CANCEL_LIKE_LECTURE)
    }

}