package com.hannah.education.teacher.dto.request

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.user.User

data class LectureCreateRequest(
    val title: String,
    val content: String,
    val thumbnailImgUrl: String,
    val isShow: Boolean,
    val tags: List<Long>,
) {
    fun toEntity(saveUser: User): Lecture {
        return Lecture(
            title = this.title,
            content = this.content,
            thumbnailImgUrl = this.thumbnailImgUrl,
            isShow = this.isShow,
            user = saveUser
        )
    }
}
