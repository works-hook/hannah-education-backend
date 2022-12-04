package com.hannah.education.teacher.dto.request

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureNotice.LectureNotice

data class NoticeRequest(
    val title: String,
    val content: String,
) {
    fun toEntity(lecture: Lecture): LectureNotice {
        return LectureNotice(
            lecture = lecture,
            title = this.title,
            content = this.content
        )
    }
}