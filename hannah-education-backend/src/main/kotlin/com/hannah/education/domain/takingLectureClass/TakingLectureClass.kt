package com.hannah.education.domain.takingLectureClass

import com.hannah.education.domain.lectureClass.LectureClass
import com.hannah.education.domain.user.User
import com.hannah.education.util.domain.BaseEntity
import com.hannah.education.util.domain.BooleanToYNConverter
import javax.persistence.*

@Entity
class TakingLectureClass(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val takingUser: User,

    @ManyToOne(fetch = FetchType.LAZY)
    val lectureClass: LectureClass,

    @Convert(converter = BooleanToYNConverter::class)
    var done: Boolean = false,
): BaseEntity() {
    fun updateDone() {
        done = true
    }
}