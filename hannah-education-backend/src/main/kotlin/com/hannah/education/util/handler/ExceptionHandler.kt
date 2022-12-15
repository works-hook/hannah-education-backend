package com.hannah.education.util.handler

import com.hannah.education.util.ApiResponse.Error
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.mail.MailSendException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler() {

    @ExceptionHandler(BusinessException::class)
    fun handleMemberException(e:BusinessException): Error<String> {
        return Error(e.errorCode)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun httpRequestMethodNotSupportedException(e: HttpRequestMethodNotSupportedException): Error<String> {
        return Error(ErrorCode.NOT_URI)
    }

    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadableException(e: HttpMessageNotReadableException): Error<String> {
        return Error(ErrorCode.NOT_BODY)
    }

    @ExceptionHandler(MailSendException::class)
    fun mailSendException(e: MailSendException): Error<String> {
        return Error(ErrorCode.ERROR_MAIL)
    }
}