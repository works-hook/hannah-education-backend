package com.hannah.education.student.controller.main

import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.student.service.main.MainService
import com.hannah.education.student.dto.response.BannerResponse
import com.hannah.education.student.dto.response.TeacherResponse
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-student")
class MainController(
    private val mainService: MainService,
) {

    @NoToken
    @GetMapping("/banner")
    fun findMainBanner(): Success<List<BannerResponse>> {
        val result = mainService.findAllBanner()
        return Success(result, SuccessCode.BANNER_LIST)
    }

    @NoToken
    @GetMapping("/teacher")
    fun findMainTeacher(): Success<List<TeacherResponse>> {
        val result = mainService.findAllTeacher()
        return Success(result, SuccessCode.TEACHER_LIST)
    }

}