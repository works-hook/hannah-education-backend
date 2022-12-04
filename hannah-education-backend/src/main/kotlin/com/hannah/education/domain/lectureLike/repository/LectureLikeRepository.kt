package com.hannah.education.domain.lectureLike.repository

import com.hannah.education.domain.lectureLike.LectureLike
import org.springframework.data.jpa.repository.JpaRepository

interface LectureLikeRepository: JpaRepository<LectureLike, Long>, LectureLikeCustomRepository
