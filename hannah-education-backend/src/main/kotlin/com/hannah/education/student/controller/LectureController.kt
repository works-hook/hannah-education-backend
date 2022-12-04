package com.hannah.education.student.controller

import com.hannah.education.domain.lecture.dto.LectureResponse
import com.hannah.education.student.dto.response.LectureDetailResponse
import com.hannah.education.student.service.LectureService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture-student")
class LectureController(
    private val studentService: LectureService,
) {

    @GetMapping("/most-taken")
    fun mostTakenLectures(): Success<List<LectureResponse>> {
        val result = studentService.mostTakenLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @GetMapping("/most-like")
    fun mostLikeLectures(): Success<List<LectureResponse>> {
        val result = studentService.mostLikeLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @GetMapping("")
    fun findAllLectures(): Success<List<LectureResponse>> {
        val result = studentService.findAllLectures()
        return Success(result, SuccessCode.ALL_LECTURE)
    }

    @GetMapping("/{lectureId}")
    fun findOneLecture(@PathVariable lectureId: Long): Success<LectureDetailResponse> {
        val result = studentService.findOneLecture(lectureId)
        return Success(result, SuccessCode.ONE_LECTURE)
    }

    @PostMapping("/take/{lectureId}/{userId}")
    fun takeLecture(@PathVariable lectureId: Long, @PathVariable userId: Long): Success<String> {
        studentService.takeLecture(lectureId, userId)
        return Success(SuccessCode.TAKING_LECTURE)
    }

    @PostMapping("/like/{lectureId}/{userId}")
    fun likeLecture(@PathVariable lectureId: Long, @PathVariable userId: Long): Success<String> {
        studentService.likeLecture(lectureId, userId)
        return Success(SuccessCode.LIKE_LECTURE)
    }

}