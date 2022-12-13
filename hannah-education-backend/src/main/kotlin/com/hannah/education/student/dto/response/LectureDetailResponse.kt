package com.hannah.education.student.dto.response

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.dto.LectureTagResponse
import com.hannah.education.domain.tag.dto.toResponse
import java.time.LocalDate

data class LectureDetailResponse(
    val lectureId: Long? = null,
    val title: String,
    val content: String,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
    val likeCount: Long,
    val teacherId: Long?,
)

fun Lecture.toLectureDetailResponse(lectureTags: List<LectureTag>, likeCount: Long?) = LectureDetailResponse(
    lectureId = this.id,
    title = this.title,
    content = this.content,
    thumbnailImgUrl = this.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() },
    likeCount = likeCount ?: 0,
    teacherId = this.user.id
)
