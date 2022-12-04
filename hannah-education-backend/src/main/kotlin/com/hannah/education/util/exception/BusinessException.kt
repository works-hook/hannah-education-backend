package com.hannah.education.util.exception

import com.hannah.education.util.code.ErrorCode

class BusinessException(
    val errorCode: ErrorCode
) : RuntimeException(errorCode.message)