package com.hannah.education.student.service

import com.hannah.education.domain.lecture.dto.LectureResponse
import com.hannah.education.domain.lecture.dto.toLectureResponse
import com.hannah.education.domain.lecture.repository.LectureRepository
import com.hannah.education.domain.lectureLike.LectureLike
import com.hannah.education.domain.lectureLike.repository.LectureLikeRepository
import com.hannah.education.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.domain.takingLecture.TakingLecture
import com.hannah.education.domain.takingLecture.repository.TakingLectureRepository
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.student.dto.response.LectureDetailResponse
import com.hannah.education.student.dto.response.toLectureDetailResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureService(
    private val lectureRepository: LectureRepository,
    private val lectureTagRepository: LectureTagRepository,
    private val lectureLikeRepository: LectureLikeRepository,
    private val userRepository: UserRepository,
    private val takingLectureRepository: TakingLectureRepository,
) {

    fun mostTakenLectures(): List<LectureResponse> {
        return lectureRepository.findMostTakenLectures()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun mostLikeLectures(): List<LectureResponse> {
        return lectureRepository.findMostLikeLectures()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findAllLectures(): List<LectureResponse> {
        return lectureRepository.findAllByStudent()
            .map {
                val lectureTags = lectureTagRepository.findTagByLecture(it)
                it.toLectureResponse(lectureTags)
            }.toList()
    }

    fun findOneLecture(lectureId: Long): LectureDetailResponse {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        val findLectureTags = lectureTagRepository.findTagByLecture(findLecture)
        val findLikeCount = lectureLikeRepository.findCountByLecture(findLecture)
        return findLecture.toLectureDetailResponse(findLectureTags, findLikeCount)
    }

    @Transactional
    fun takeLecture(lectureId: Long, userId: Long) {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        val save = TakingLecture(user = findUser, lecture = findLecture)
        takingLectureRepository.save(save)
    }

    @Transactional
    fun likeLecture(lectureId: Long, userId: Long) {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        val save = LectureLike(lecture = findLecture, user = findUser)
        lectureLikeRepository.save(save)
    }
}