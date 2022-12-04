package com.hannah.education.domain.lecture.repository

import com.hannah.education.domain.lecture.Lecture
import org.springframework.data.jpa.repository.JpaRepository

interface LectureRepository : JpaRepository<Lecture, Long>, LectureCustomRepository
