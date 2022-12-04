package com.hannah.education.domain.lectureNotice.repositoroy

import com.hannah.education.domain.lectureNotice.LectureNotice
import org.springframework.data.jpa.repository.JpaRepository

interface LectureNoticeRepository: JpaRepository<LectureNotice, Long>, LectureNoticeCustomRepository