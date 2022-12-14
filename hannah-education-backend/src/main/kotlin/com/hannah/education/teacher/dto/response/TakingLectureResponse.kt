package com.hannah.education.teacher.dto.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.hannah.education.domain.lectureNotice.LectureNotice
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.dto.LectureTagResponse
import com.hannah.education.domain.tag.dto.toResponse
import com.hannah.education.domain.takingLecture.TakingLecture
import java.time.LocalDateTime

data class TakingLectureResponse(
    val lectureId: Long?,
    val title: String,
    val thumbnailImgUrl: String,
    val tags: List<LectureTagResponse>,
    val notices: List<NoticeResponse>,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val startDate: LocalDateTime,
    val classCount: Long,
    val doneClassCount: Long
)

fun TakingLecture.toResponse(
    tags: List<LectureTag>,
    notices: List<LectureNotice>,
    classCount: Long,
    doneClassCount: Long
): TakingLectureResponse =
    TakingLectureResponse(
        lectureId = this.lecture.id,
        title = this.lecture.title,
        thumbnailImgUrl = this.lecture.thumbnailImgUrl,
        tags = tags.map { it.toResponse() },
        notices = notices.map { it.toResponse() },
        startDate = this.createdDate,
        classCount = classCount,
        doneClassCount = doneClassCount
    )
