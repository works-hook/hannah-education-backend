package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lectureClass.LectureClass
import java.time.LocalDateTime

data class ClassResponse(
    val classId: Long?,
    val title: String,
    val content: String,
    val period: LocalDateTime,
    val isAssignment: Boolean,
    val assignmentContent: String?
)

fun LectureClass.toResponse(): ClassResponse = ClassResponse(
    classId = this.id,
    title = this.title,
    content = this.content,
    period = this.period,
    isAssignment = this.isAssignment,
    assignmentContent = this.assignmentContent,
)
