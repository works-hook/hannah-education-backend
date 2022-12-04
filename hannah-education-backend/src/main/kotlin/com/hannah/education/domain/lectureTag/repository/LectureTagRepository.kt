package com.hannah.education.domain.lectureTag.repository

import com.hannah.education.domain.lectureTag.LectureTag
import org.springframework.data.jpa.repository.JpaRepository

interface LectureTagRepository : JpaRepository<LectureTag, Long>, LectureTagCustomRepository