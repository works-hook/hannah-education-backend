package com.hannah.education.common.user.dto.request

data class UserLoginRequest(
    val account: String,
    val password: String,
)
