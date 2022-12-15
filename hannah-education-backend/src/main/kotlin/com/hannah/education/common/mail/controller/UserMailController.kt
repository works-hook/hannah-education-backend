package com.hannah.education.common.mail.controller

import com.hannah.education.common.mail.dto.request.CertificationCheckRequest
import com.hannah.education.common.mail.dto.request.CertificationRequest
import com.hannah.education.common.mail.service.UserMailService
import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-certification")
class UserMailController(
    private val userMailService: UserMailService
) {

    @NoToken
    @PostMapping("")
    fun memberCertification(@RequestBody request: CertificationRequest): Success<String> {
        userMailService.sendMail(request.email)
        return Success(SuccessCode.SUCCESS_SEND_MAIL)
    }

    @NoToken
    @PostMapping("/check")
    fun memberCheckCertification(@RequestBody request: CertificationCheckRequest): Success<String> {
        userMailService.checkCertification(request.certificationNumber)
        return Success(SuccessCode.SUCCESS_CHECK_MAIL)
    }

}