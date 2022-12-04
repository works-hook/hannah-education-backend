package com.hannah.education.domain.takingLecture

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.user.User
import com.hannah.education.util.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne

@Entity
class TakingLecture(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @OneToOne
    val user: User,

    @OneToOne
    val lecture: Lecture,
): BaseEntity()