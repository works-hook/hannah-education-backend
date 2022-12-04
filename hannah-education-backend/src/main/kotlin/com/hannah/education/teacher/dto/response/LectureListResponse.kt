package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lecture.Lecture

data class LectureListResponse(
    val lectureId: Long?,
    val title: String,
    val startDate: String,
    val endDate: String,
)

fun Lecture.toListResponse(): LectureListResponse = LectureListResponse(
    lectureId = this.id,
    title = this.title,
    startDate = this.startDate.toString(),
    endDate = this.endDate.toString(),
)
