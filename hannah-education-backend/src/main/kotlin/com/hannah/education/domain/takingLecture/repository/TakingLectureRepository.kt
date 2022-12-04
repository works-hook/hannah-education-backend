package com.hannah.education.domain.takingLecture.repository

import com.hannah.education.domain.takingLecture.TakingLecture
import org.springframework.data.jpa.repository.JpaRepository

interface TakingLectureRepository: JpaRepository<TakingLecture, Long>, TakingLectureCustomRepository