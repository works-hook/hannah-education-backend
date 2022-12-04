package com.hannah.education.teacher.controller

import com.hannah.education.teacher.dto.request.NoticeRequest
import com.hannah.education.teacher.dto.response.NoticeResponse
import com.hannah.education.teacher.service.NoticeTeacherService
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/lecture-teacher/notice")
class NoticeTeacherController(
    private val noticeService: NoticeTeacherService
) {

    @GetMapping("/{lectureId}")
    fun findAllNotice(@PathVariable lectureId: Long): Success<List<NoticeResponse>> {
        val result = noticeService.findAllNotice(lectureId)
        return Success(result, SuccessCode.ALL_NOTICE)
    }

    @PostMapping("/{lectureId}")
    fun createNotice(@PathVariable lectureId: Long, @RequestBody request: NoticeRequest): Success<String> {
        noticeService.createNotice(lectureId, request)
        return Success(SuccessCode.NOTICE_CREATE)
    }

    @PatchMapping("/{noticeId}")
    fun modifyNotice(@PathVariable noticeId: Long, @RequestBody request: NoticeRequest): Success<String> {
        noticeService.modifyNotice(noticeId, request)
        return Success(SuccessCode.NOTICE_MODIFY)
    }

    @DeleteMapping("/{noticeId}")
    fun deleteNotice(@PathVariable noticeId: Long): Success<String> {
        noticeService.deleteNotice(noticeId)
        return Success(SuccessCode.NOTICE_DELETE)
    }

}