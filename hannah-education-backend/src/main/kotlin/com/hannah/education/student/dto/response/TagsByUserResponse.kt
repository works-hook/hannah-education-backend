package com.hannah.education.student.dto.response

data class TagsByUserResponse(
    val tagId: Long?,
    val name: String,
    val color: String,
    val count: Long,
)