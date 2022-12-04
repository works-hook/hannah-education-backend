package com.hannah.education.student.dto.response

import com.hannah.education.domain.user.User
import java.time.LocalDate

data class StudentOneResponse(
    val id: Long?,
    val account: String,
    val name: String,
    val brith: LocalDate?,
    val email: String,
    val phoneNumber: String,
    val imageUrl: String?,
)

fun User.toStudentOneResponse() : StudentOneResponse = StudentOneResponse(
    id = this.id,
    account = this.account,
    name = this.name,
    brith = this.brith,
    email = this.email,
    phoneNumber = this.phoneNumber,
    imageUrl = this.imageUrl
)
