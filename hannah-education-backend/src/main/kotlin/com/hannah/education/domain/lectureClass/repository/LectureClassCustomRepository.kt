package com.hannah.education.domain.lectureClass.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureClass.LectureClass
import com.hannah.education.domain.takingLectureClass.TakingLectureClass
import com.hannah.education.domain.user.User

interface LectureClassCustomRepository {

    fun findClassById(classId: Long): LectureClass?

    fun findClassAllByLecture(lecture: Lecture): List<LectureClass>

    fun findClassCountByLecture(findLecture: Lecture): Long?

    fun findDoneClassCountByUser(findUser: User): Long?

    fun findTakingClassByUser(userId: Long, findLecture: Lecture): List<TakingLectureClass>

}
