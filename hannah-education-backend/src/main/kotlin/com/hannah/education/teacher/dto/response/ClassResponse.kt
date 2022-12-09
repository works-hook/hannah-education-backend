package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lectureClass.LectureClass
import java.time.LocalDate
import java.time.LocalTime

data class ClassResponse(
    val classId: Long?,
    val title: String,
    val content: String,
    val startDate: LocalDate,
    val startTime: LocalTime,
    val isAssignment: Boolean,
    val assignmentContent: String?
)

fun LectureClass.toResponse(): ClassResponse = ClassResponse(
    classId = this.id,
    title = this.title,
    content = this.content,
    startDate = this.startDate,
    startTime = this.startTime,
    isAssignment = this.isAssignment,
    assignmentContent = this.assignmentContent,
)
