package com.hannah.education.common.user.dto.request

data class UserUpdatePasswordRequest(
    val originPassword: String,
    val updatePassword: String,
)
