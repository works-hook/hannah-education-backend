package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lectureClass.LectureClass
import java.time.LocalDate
import java.time.LocalTime

data class ClassResponse(
    val classId: Long?,
    val title: String,
    val content: String,
)

fun LectureClass.toResponse(): ClassResponse = ClassResponse(
    classId = this.id,
    title = this.title,
    content = this.content,
)
