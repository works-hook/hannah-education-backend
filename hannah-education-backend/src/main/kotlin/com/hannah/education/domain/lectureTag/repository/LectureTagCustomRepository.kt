package com.hannah.education.domain.lectureTag.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureTag.LectureTag

interface LectureTagCustomRepository {

    fun findTagByLecture(lecture: Lecture): List<LectureTag>

}
