package com.hannah.education.domain.takingLecture.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.takingLecture.TakingLecture
import com.hannah.education.domain.user.User
import com.hannah.education.student.dto.response.TagsByUserResponse

interface TakingLectureCustomRepository {

    fun findTakingLectureTagsByUser(user: User): List<TagsByUserResponse>

    fun findTakingLectureByUser(user: User): List<TakingLecture>

    fun findCountByLecture(lecture: Lecture): Long?

}
