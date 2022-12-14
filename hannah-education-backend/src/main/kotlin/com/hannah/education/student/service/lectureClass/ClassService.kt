package com.hannah.education.student.service.lectureClass

import com.hannah.education.domain.lecture.repository.LectureRepository
import com.hannah.education.domain.lectureClass.repository.LectureClassRepository
import com.hannah.education.domain.lectureNotice.repositoroy.LectureNoticeRepository
import com.hannah.education.domain.takingLectureClass.repository.TakingLectureClassRepository
import com.hannah.education.student.dto.response.TakingLectureClassResponse
import com.hannah.education.student.dto.response.toResponse
import com.hannah.education.teacher.dto.response.NoticeResponse
import com.hannah.education.teacher.dto.response.toResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClassService(
    private val noticeRepository: LectureNoticeRepository,
    private val lectureRepository: LectureRepository,
    private val lectureClassRepository: LectureClassRepository,
    private val takingLectureClassRepository: TakingLectureClassRepository,
) {

    fun findOneNotice(noticeId: Long): NoticeResponse {
        return noticeRepository.findNoticeById(noticeId)
            ?.toResponse()
            ?: throw BusinessException(ErrorCode.NOT_EXIST_NOTICE)
    }

    fun findAllClass(userId: Long, lectureId: Long): List<TakingLectureClassResponse> {
        val findLecture = lectureRepository.findLectureById(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        return lectureClassRepository
            .findTakingClassByUser(userId, findLecture)
            .map { it.toResponse() }
    }

    @Transactional
    fun doneTakingClass(takingClassId: Long) {
        val findClass = takingLectureClassRepository.findByIdOrNull(takingClassId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_CLASS)
        findClass.updateDone()
    }

}