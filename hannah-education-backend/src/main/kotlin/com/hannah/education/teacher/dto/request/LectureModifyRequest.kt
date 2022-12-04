package com.hannah.education.teacher.dto.request

data class LectureModifyRequest(
    val title: String,
    val content: String,
    val startDate: String,
    val endDate: String,
    val thumbnailImgUrl: String,
    val tags: List<Long>,
)
