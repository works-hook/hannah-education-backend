package com.hannah.education.util

import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.code.SuccessCode

sealed class ApiResponse<T>(
    open val data: T? = null,
    val code: String? = null,
    val message: String? = null
) {

    data class Success<T>(override val data: T?, val success: SuccessCode) : ApiResponse<T>(data = data, code = success.code, message = success.message) {
        constructor(success: SuccessCode) : this(null, success)
    }

    data class Error<T>(val error: ErrorCode) : ApiResponse<T>(code = error.code, message = error.message)
}