package com.hannah.education.teacher.dto.request

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureClass.LectureClass
import java.time.LocalDate
import java.time.LocalTime

data class ClassCreateRequest(
    val title: String,
    val content: String,
) {

    fun toClassEntity(lecture: Lecture): LectureClass {
        return LectureClass(
            lecture = lecture,
            title = this.title,
            content = this.content,
        )
    }

}
