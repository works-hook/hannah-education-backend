package com.hannah.education.domain.takingLectureClass.repository

import com.hannah.education.domain.takingLectureClass.TakingLectureClass
import org.springframework.data.jpa.repository.JpaRepository

interface TakingLectureClassRepository: JpaRepository<TakingLectureClass, Long>, TakingLectureClassCustomRepository {
}