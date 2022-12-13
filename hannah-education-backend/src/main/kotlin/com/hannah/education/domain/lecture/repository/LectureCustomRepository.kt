package com.hannah.education.domain.lecture.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.user.User

interface LectureCustomRepository {

    fun findAllByTeacher(teacherId: Long?): List<Lecture>

    fun findLectureId(lectureId: Long): Lecture?

    fun findMostTakenLectures(): List<Lecture>

    fun findMostLikeLectures(): List<Lecture>

    fun findAllByStudent(): List<Lecture>
    fun findCountByTeacher(user: User): Long?

}
