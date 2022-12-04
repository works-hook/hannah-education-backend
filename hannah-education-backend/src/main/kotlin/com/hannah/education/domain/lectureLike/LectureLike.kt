package com.hannah.education.domain.lectureLike

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.user.User
import com.hannah.education.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureLike(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    @OneToOne
    val user: User,
): BaseEntity()