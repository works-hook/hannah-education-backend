package com.hannah.education.student.service

import com.hannah.education.domain.banner.repository.BannerRepository
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.student.dto.response.BannerResponse
import com.hannah.education.student.dto.response.TeacherResponse
import com.hannah.education.student.dto.response.toResponse
import com.hannah.education.student.dto.response.toTeacherResponse
import org.springframework.stereotype.Service

@Service
class MainService(
    private val bannerRepository: BannerRepository,
    private val userRepository: UserRepository,
) {

    fun findAllBanner(): List<BannerResponse> {
        return bannerRepository
            .findAll()
            .map { it.toResponse() }
    }

    fun findAllTeacher(): List<TeacherResponse> {
        return userRepository
            .findTeachers()
            .shuffled()
            .map { it.toTeacherResponse() }
            .subList(0, 5)
    }

}