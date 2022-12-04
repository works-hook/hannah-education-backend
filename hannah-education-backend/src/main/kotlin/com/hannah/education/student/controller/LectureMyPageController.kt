package com.hannah.education.student.controller

import com.hannah.education.domain.lecture.dto.LectureResponse
import com.hannah.education.lectureservice.teacher.dto.response.TakingLectureResponse
import com.hannah.education.student.dto.response.TagsByUserResponse
import com.hannah.education.student.service.LectureMyPageService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture-student")
class LectureMyPageController(
    private val myPageService: LectureMyPageService
) {

    @GetMapping("/like/{userId}")
    fun findLectureLikeByUser(@PathVariable userId: Long): Success<List<LectureResponse>> {
        val result = myPageService.findLectureByLiked(userId)
        return Success(result, SuccessCode.LIKE_LECTURE_LIST)
    }

    @GetMapping("/tag/{userId}")
    fun findTagsByUser(@PathVariable userId: Long): Success<List<TagsByUserResponse>> {
        val result = myPageService.findTagsByUser(userId)
        return Success(result, SuccessCode.TAKING_LECTURE_TAG)
    }

    @GetMapping("/taking/{userId}")
    fun findTakingLectures(@PathVariable userId: Long): Success<List<TakingLectureResponse>> {
        val result = myPageService.findTakingLecture(userId)
        return Success(result, SuccessCode.TAKING_LECTURE_LIST)
    }


}