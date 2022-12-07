package com.hannah.education.common.user.dto.response

import com.hannah.education.domain.user.User

data class UserLoginSuccessResponse(
    val userId: Long?,
    val account: String,
    val token: String,
)

fun User.toLoginResponse(token: String) = UserLoginSuccessResponse(
    userId = this.id,
    account = this.account,
    token = token
)
