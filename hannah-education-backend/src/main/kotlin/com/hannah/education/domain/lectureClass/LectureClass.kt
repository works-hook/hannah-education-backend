package com.hannah.education.domain.lectureClass

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.teacher.dto.request.ClassModifyRequest
import com.hannah.education.util.domain.BaseEntity
import javax.persistence.*

@Entity
class LectureClass(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    val lecture: Lecture,

    var title: String,
    var content: String,
): BaseEntity() {

    fun update(request: ClassModifyRequest) {
        this.title = request.title
        this.content = request.content
    }

}