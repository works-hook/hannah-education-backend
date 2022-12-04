package com.hannah.education.domain.user

import com.hannah.education.student.dto.request.StudentModifyRequest
import com.hannah.education.teacher.dto.request.TeacherModifyRequest
import com.hannah.education.util.domain.BaseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate
import javax.persistence.*

@Entity
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val account: String,
    var password: String,
    var name: String,
    var email: String,
    var phoneNumber: String,
    var oneLineIntroduction: String? = null,
    var introduction: String? = null,
    var brith: LocalDate? = null,
    var imageUrl: String? = null,
    @Enumerated(value = EnumType.STRING)
    val userType: UserType,
): BaseEntity() {

    fun encodingPassword(passwordEncoder: PasswordEncoder) {
        this.password = passwordEncoder.encode(this.password)
    }

    fun updatePassword(updatePassword: String) {
        this.password = updatePassword
    }

    fun studentUpdate(request: StudentModifyRequest) {
        request.name.let { this.name = it }
        request.email.let { this.email = it }
        request.phoneNumber.let { this.phoneNumber = it }
        request.brith?.let { this.brith = LocalDate.parse(it) }
        request.imageUrl?.let { this.imageUrl = it }
    }

    fun teacherUpdate(request: TeacherModifyRequest) {
        request.name.let { this.name = it }
        request.email.let { this.email = it }
        request.phoneNumber.let { this.phoneNumber = it }
        request.brith?.let { this.brith = LocalDate.parse(it) }
        request.imageUrl?.let { this.imageUrl = it }
        request.oneLineIntroduction?.let { this.oneLineIntroduction = it }
        request.introduction?.let { this.introduction = it }
    }
}