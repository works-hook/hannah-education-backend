package com.hannah.education.domain.lectureTag

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.tag.Tag
import com.hannah.education.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureTag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    @ManyToOne(fetch = FetchType.LAZY)
    val tag: Tag,
):BaseEntity()