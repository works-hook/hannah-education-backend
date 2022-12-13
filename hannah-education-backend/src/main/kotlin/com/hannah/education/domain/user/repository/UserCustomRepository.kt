package com.hannah.education.domain.user.repository

import com.hannah.education.domain.user.User

interface UserCustomRepository {

    fun findUserAll(): List<User>

    fun findUserById(id: Long?): User?

    fun findByAccount(account: String): User?

    fun findTeachers(): List<User>

    fun findTeacherByLectureId(lectureId: Long): User?

}
