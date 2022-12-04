package com.hannah.education.domain.tag.dto

import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.Tag

data class LectureTagResponse(
    val tagId: Long,
    val name: String,
    val color: String,
)

fun LectureTag.toResponse(): LectureTagResponse = LectureTagResponse(
    tagId = this.tag.id,
    name = this.tag.name,
    color = this.tag.color,
)