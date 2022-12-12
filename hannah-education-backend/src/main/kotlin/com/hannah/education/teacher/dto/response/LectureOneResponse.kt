package com.hannah.education.teacher.dto.response

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.dto.LectureTagResponse
import com.hannah.education.domain.tag.dto.toResponse
import java.time.LocalDateTime

data class LectureOneResponse(
    val lectureId: Long?,
    val title: String,
    val content: String,
    val thumbnailImgUrl: String,
    val isShow: Boolean,
    val createdDate: LocalDateTime,
    val tags: List<LectureTagResponse>,
)

fun Lecture.toOneResponse(lectureTags: List<LectureTag>): LectureOneResponse = LectureOneResponse(
    lectureId = this.id,
    title = this.title,
    content = this.content,
    thumbnailImgUrl = this.thumbnailImgUrl,
    isShow = this.isShow,
    createdDate = this.createdDate,
    tags = lectureTags.map { it.toResponse() }.toList()
)