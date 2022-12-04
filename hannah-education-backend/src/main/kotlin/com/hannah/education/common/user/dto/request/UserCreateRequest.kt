package com.hannah.education.common.user.dto.request

import com.hannah.education.domain.user.UserType
import com.hannah.education.domain.user.User

data class UserCreateRequest(
    val account: String,
    val password: String,
    val name: String,
    val email: String,
    val phoneNumber: String,
    val userType: UserType,
) {
    fun toEntity(): User {
        return User(
            account = this.account,
            password = this.password,
            name = this.name,
            email = this.email,
            phoneNumber = this.phoneNumber,
            userType = this.userType,
        )
    }

}