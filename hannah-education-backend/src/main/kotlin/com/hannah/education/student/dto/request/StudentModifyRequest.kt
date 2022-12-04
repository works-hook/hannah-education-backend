package com.hannah.education.student.dto.request

data class StudentModifyRequest(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val brith: String?,
    val imageUrl: String?,
)