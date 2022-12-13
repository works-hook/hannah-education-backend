package com.hannah.education.student.dto.response

import com.hannah.education.domain.user.User

class TeacherDetailResponse(
    val teacherId: Long?,
    val name: String,
    val imageUrl: String?,
    val lectureCount: Long,
    val studentCount: Long,
    val oneLineIntroduction: String?,
    val introduction: String?
)

fun User.toTeacherDetailResponse(lectureCount: Long, studentCount: Long): TeacherDetailResponse = TeacherDetailResponse(
    teacherId = this.id,
    name = this.name,
    imageUrl = this.imageUrl,
    lectureCount = lectureCount,
    studentCount = studentCount,
    oneLineIntroduction = this.oneLineIntroduction,
    introduction = this.introduction
)
