package com.hannah.education.util

import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.code.SuccessCode

sealed class ApiResponse<T>(
    val data: T? = null,
    val code: String? = null,
    val message: String? = null
) {

    class Success<T>(data: T?, success: SuccessCode) : ApiResponse<T>(data = data, code = success.code, message = success.message) {
        constructor(success: SuccessCode) : this(null, success)
    }

    class Error<T>(error: ErrorCode) : ApiResponse<T>(code = error.code, message = error.message)
}