package com.hannah.education.student.controller.lectureClass

import com.hannah.education.config.resolver.UserId
import com.hannah.education.student.dto.response.TakingLectureClassResponse
import com.hannah.education.student.service.lectureClass.ClassService
import com.hannah.education.teacher.dto.response.ClassResponse
import com.hannah.education.teacher.dto.response.NoticeResponse
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/class-student")
class ClassController(
    private val classService: ClassService,
) {

    @GetMapping("/notice/{noticeId}")
    fun findOneNotice(@PathVariable noticeId: Long): Success<NoticeResponse> {
        val result = classService.findOneNotice(noticeId)
        return Success(result, SuccessCode.ONE_NOTICE)
    }

    @GetMapping("/{lectureId}")
    fun findAllClass(@UserId userId: Long, @PathVariable lectureId: Long): Success<List<TakingLectureClassResponse>> {
        val result = classService.findAllClass(userId, lectureId)
        return Success(result, SuccessCode.ALL_CLASS)
    }

    @PostMapping("/{takingClassId}")
    fun doneTakingClass(@PathVariable takingClassId: Long): Success<String> {
        classService.doneTakingClass(takingClassId);
        return Success(SuccessCode.SUCCESS_CLASS_DONE)
    }
}