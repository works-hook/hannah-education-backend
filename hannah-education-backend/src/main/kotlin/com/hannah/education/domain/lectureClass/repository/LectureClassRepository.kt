package com.hannah.education.domain.lectureClass.repository

import com.hannah.education.domain.lectureClass.LectureClass
import org.springframework.data.jpa.repository.JpaRepository

interface LectureClassRepository: JpaRepository<LectureClass, Long>, LectureClassCustomRepository