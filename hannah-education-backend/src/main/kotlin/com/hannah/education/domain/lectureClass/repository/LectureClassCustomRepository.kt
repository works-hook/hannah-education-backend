package com.hannah.education.domain.lectureClass.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureClass.LectureClass

interface LectureClassCustomRepository {

    fun findClassById(classId: Long): LectureClass?

    fun findClassAllByLecture(lecture: Lecture): List<LectureClass>

}
