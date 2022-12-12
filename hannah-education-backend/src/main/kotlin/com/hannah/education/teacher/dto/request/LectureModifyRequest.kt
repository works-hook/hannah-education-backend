package com.hannah.education.teacher.dto.request

data class LectureModifyRequest(
    val title: String,
    val content: String,
    val thumbnailImgUrl: String,
    val isShow: Boolean,
    val tags: List<Long>,
)
