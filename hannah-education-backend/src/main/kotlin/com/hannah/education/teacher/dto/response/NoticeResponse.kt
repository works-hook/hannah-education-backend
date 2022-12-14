package com.hannah.education.teacher.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.hannah.education.domain.lectureNotice.LectureNotice
import java.time.LocalDateTime

data class NoticeResponse(
    val noticeId: Long?,
    val title: String,
    val content: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdDate: LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val modifiedDate: LocalDateTime,
)

fun LectureNotice.toResponse(): NoticeResponse = NoticeResponse(
    noticeId = this.id,
    title = this.title,
    content = this.content,
    createdDate = this.createdDate,
    modifiedDate = this.modifiedDate
)
