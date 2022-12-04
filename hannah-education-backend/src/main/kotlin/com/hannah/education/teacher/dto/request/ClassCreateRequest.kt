package com.hannah.education.teacher.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureClass.LectureClass
import java.time.LocalDateTime

data class ClassCreateRequest(
    val title: String,
    val content: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val period: LocalDateTime,
    val isAssignment: Boolean,
    val assignmentContent: String,
) {

    fun toClassEntity(lecture: Lecture): LectureClass {
        return LectureClass(
            lecture = lecture,
            title = this.title,
            content = this.content,
            period = this.period,
            isAssignment = this.isAssignment,
            assignmentContent = this.assignmentContent,
        )
    }

}
