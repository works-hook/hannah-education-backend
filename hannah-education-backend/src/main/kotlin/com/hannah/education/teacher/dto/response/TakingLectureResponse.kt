package com.hannah.education.lectureservice.teacher.dto.response

import com.hannah.education.domain.lectureNotice.LectureNotice
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.tag.dto.LectureTagResponse
import com.hannah.education.domain.tag.dto.toResponse
import com.hannah.education.domain.takingLecture.TakingLecture
import com.hannah.education.teacher.dto.response.NoticeResponse
import com.hannah.education.teacher.dto.response.toResponse
import java.time.LocalDate

data class TakingLectureResponse(
    val lectureId: Long?,
    val title: String,
    val thumbnailImgUrl: String,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val tags: List<LectureTagResponse>,
    val notices: List<NoticeResponse>,
)

fun TakingLecture.toResponse(tags: List<LectureTag>, notices: List<LectureNotice>): TakingLectureResponse =
    TakingLectureResponse(
        lectureId = this.lecture.id,
        title = this.lecture.title,
        thumbnailImgUrl = this.lecture.thumbnailImgUrl,
        startDate = this.lecture.startDate,
        endDate = this.lecture.endDate,
        tags = tags.map { it.toResponse() },
        notices = notices.map { it.toResponse() }
    )
