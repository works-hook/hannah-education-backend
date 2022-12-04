package com.hannah.education.teacher.dto.request

data class TeacherModifyRequest(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val brith: String?,
    val imageUrl: String?,
    val oneLineIntroduction: String?,
    val introduction: String?,
)