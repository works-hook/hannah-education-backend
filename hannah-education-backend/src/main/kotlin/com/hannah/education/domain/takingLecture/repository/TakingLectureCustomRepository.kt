package com.hannah.education.domain.takingLecture.repository

import com.hannah.education.domain.takingLecture.TakingLecture
import com.hannah.education.domain.user.User
import com.hannah.education.student.dto.response.TagsByUserResponse

interface TakingLectureCustomRepository {

    fun findTakingLectureTagsByUser(user: User): List<TagsByUserResponse>

    fun findTakingLectureByUser(user: User): List<TakingLecture>

}
