package com.hannah.education.domain.lectureLike.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureLike.LectureLike
import com.hannah.education.domain.user.User

interface LectureLikeCustomRepository {

    fun findCountByLecture(findLecture: Lecture): Long?

    fun findLectureByUser(findUser: User): List<LectureLike>

    fun checkLikedLectureByUser(user: User, lectureId: Long): Boolean

    fun findLikeByAll(user: User, lecture: Lecture): LectureLike?

}
