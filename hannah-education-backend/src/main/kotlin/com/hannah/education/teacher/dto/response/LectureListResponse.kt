package com.hannah.education.teacher.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.hannah.education.domain.lecture.Lecture
import java.time.LocalDateTime

data class LectureListResponse(
    val lectureId: Long?,
    val title: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdDate: LocalDateTime,
    val isShow: Boolean,
)

fun Lecture.toListResponse(): LectureListResponse = LectureListResponse(
    lectureId = this.id,
    title = this.title,
    createdDate = this.createdDate,
    isShow = this.isShow,
)
