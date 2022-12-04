package com.hannah.education.student.dto.response

import com.hannah.education.domain.user.User

data class TeacherResponse(
    val name: String,
    val oneLineIntroduction: String?,
    val imageUrl: String?,
)

fun User.toTeacherResponse(): TeacherResponse = TeacherResponse(
    name = this.name,
    oneLineIntroduction = this.oneLineIntroduction,
    imageUrl = this.imageUrl
)
