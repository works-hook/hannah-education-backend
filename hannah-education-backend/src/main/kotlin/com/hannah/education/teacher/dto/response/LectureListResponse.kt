package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lecture.Lecture
import java.time.LocalDate

data class LectureListResponse(
    val lectureId: Long?,
    val title: String,
    val startDate: String,
    val endDate: String,
    val state: String,
)

fun getState(startDate: LocalDate, endDate: LocalDate): String {
    val nowDate = LocalDate.now()
    val compareToStart = startDate.compareTo(nowDate)
    val compareToEnd = endDate.compareTo(nowDate)
    return when {
        compareToStart > 0 -> "danger"
        compareToEnd < 0 -> "success"
        compareToStart > 0 && compareToEnd < 0 -> "warning"
        else -> "warning"
    }
}

fun Lecture.toListResponse(): LectureListResponse = LectureListResponse(
    lectureId = this.id,
    title = this.title,
    startDate = this.startDate.toString(),
    endDate = this.endDate.toString(),
    state = getState(this.startDate, this.endDate)
)
