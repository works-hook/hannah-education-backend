package com.hannah.education.domain.lecture

import com.hannah.education.teacher.dto.request.LectureModifyRequest
import com.hannah.education.domain.user.User
import com.hannah.education.util.domain.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
class Lecture(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    @Column(columnDefinition="LONGTEXT")
    var content: String,

    var thumbnailImgUrl: String,

    var isShow: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    val user: User,
): BaseEntity() {

    fun update(request: LectureModifyRequest) {
        this.title = request.title
        this.content = request.content
        this.thumbnailImgUrl = request.thumbnailImgUrl
        this.isShow = request.isShow
    }
}