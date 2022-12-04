package com.hannah.education.domain.lecture.dto

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureLike.LectureLike
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.dto.LectureTagResponse
import com.hannah.education.domain.tag.dto.toResponse

data class LectureResponse(
    val lectureId: Long? = null,
    val title: String,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
)

fun Lecture.toLectureResponse(lectureTags: List<LectureTag>): LectureResponse = LectureResponse(
    lectureId = this.id,
    title = this.title,
    thumbnailImgUrl = this.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() }
)

fun LectureLike.toLectureResponse(lectureTags: List<LectureTag>): LectureResponse = LectureResponse(
    lectureId = this.lecture.id,
    title = this.lecture.title,
    thumbnailImgUrl = this.lecture.thumbnailImgUrl,
    tags = lectureTags.map { it.toResponse() }
)
