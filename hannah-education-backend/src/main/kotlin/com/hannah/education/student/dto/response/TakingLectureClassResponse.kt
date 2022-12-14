package com.hannah.education.student.dto.response

import com.hannah.education.domain.takingLectureClass.TakingLectureClass

data class TakingLectureClassResponse(
    val takingClassId: Long?,
    val classId: Long?,
    val title: String,
    val content: String,
    val isDone: Boolean,
)

fun TakingLectureClass.toResponse(): TakingLectureClassResponse = TakingLectureClassResponse(
    takingClassId = this.id,
    classId = this.lectureClass.id,
    title = this.lectureClass.title,
    content = this.lectureClass.content,
    isDone = this.done
)
