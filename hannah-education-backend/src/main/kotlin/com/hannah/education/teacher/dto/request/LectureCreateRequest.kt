package com.hannah.education.teacher.dto.request

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.user.User
import java.time.LocalDate

data class LectureCreateRequest(
    val title: String,
    val content: String,
    val startDate: String,
    val endDate: String,
    val thumbnailImgUrl: String,
    val tags: List<Long>,
) {
    fun toEntity(saveUser: User): Lecture {
        return Lecture(
            title = this.title,
            content = this.content,
            startDate = LocalDate.parse(this.startDate),
            endDate = LocalDate.parse(this.endDate),
            thumbnailImgUrl = this.thumbnailImgUrl,
            user = saveUser
        )
    }
}
