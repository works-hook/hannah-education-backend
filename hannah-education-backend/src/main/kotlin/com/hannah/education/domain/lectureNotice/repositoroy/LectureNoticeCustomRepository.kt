package com.hannah.education.domain.lectureNotice.repositoroy

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureNotice.LectureNotice

interface LectureNoticeCustomRepository {

    fun findNoticeAll(lecture: Lecture): List<LectureNotice>

    fun findNoticeById(noticeId: Long): LectureNotice?

}
