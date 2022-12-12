package com.hannah.education.student.service.myPage

import com.hannah.education.domain.lecture.dto.LectureResponse
import com.hannah.education.domain.lecture.dto.toLectureResponse
import com.hannah.education.domain.lectureLike.repository.LectureLikeRepository
import com.hannah.education.domain.lectureNotice.repositoroy.LectureNoticeRepository
import com.hannah.education.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.domain.takingLecture.repository.TakingLectureRepository
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.teacher.dto.response.TakingLectureResponse
import com.hannah.education.teacher.dto.response.toResponse
import com.hannah.education.student.dto.response.TagsByUserResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service

@Service
class MyPageService(
    private val noticeRepository: LectureNoticeRepository,
    private val takingLectureRepository: TakingLectureRepository,
    private val lectureTagRepository: LectureTagRepository,
    private val lectureLikeRepository: LectureLikeRepository,
    private val userRepository: UserRepository,
) {

    fun findLectureByLiked(userId: Long): List<LectureResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return lectureLikeRepository.findLectureByUser(findUser)
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it.lecture)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findTagsByUser(userId: Long): List<TagsByUserResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return takingLectureRepository.findTakingLectureTagsByUser(findUser)
    }

    fun findTakingLecture(userId: Long): List<TakingLectureResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        return takingLectureRepository.findTakingLectureByUser(findUser)
            .map {
                val tags = lectureTagRepository.findTagByLecture(it.lecture)
                val notices = noticeRepository.findNoticeAll(it.lecture)
                it.toResponse(tags, notices)
            }.toList()
    }

}