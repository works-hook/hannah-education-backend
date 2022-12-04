package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.user.User
import java.time.LocalDate

data class TeacherOneResponse(
    val id: Long?,
    val account: String,
    val name: String,
    val brith: LocalDate?,
    val email: String,
    val phoneNumber: String,
    val imageUrl: String?,
    val oneLineIntroduction: String?,
    val introduction: String?,
)

fun User.toTeacherOneResponse() : TeacherOneResponse = TeacherOneResponse(
    id = this.id,
    account = this.account,
    name = this.name,
    brith = this.brith,
    email = this.email,
    phoneNumber = this.phoneNumber,
    imageUrl = this.imageUrl,
    oneLineIntroduction = this.oneLineIntroduction,
    introduction = this.introduction,
)
