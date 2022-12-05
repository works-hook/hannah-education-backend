package com.hannah.education.teacher.service.lecture

import com.hannah.education.domain.lecture.repository.LectureRepository
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.lectureTag.repository.LectureTagRepository
import com.hannah.education.domain.tag.repository.TagRepository
import com.hannah.education.domain.user.repository.UserRepository
import com.hannah.education.teacher.dto.request.LectureCreateRequest
import com.hannah.education.teacher.dto.request.LectureModifyRequest
import com.hannah.education.teacher.dto.response.LectureListResponse
import com.hannah.education.teacher.dto.response.LectureOneResponse
import com.hannah.education.teacher.dto.response.toListResponse
import com.hannah.education.teacher.dto.response.toOneResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LectureTeacherService(
    private val lectureRepository: LectureRepository,
    private val userRepository: UserRepository,
    private val tagRepository: TagRepository,
    private val lectureTagRepository: LectureTagRepository,
) {

    @Transactional
    fun createLecture(request: LectureCreateRequest) {
        val findUser = userRepository.findUserById(request.userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)
        val lecture = request.toEntity(findUser)

        val tags = tagRepository.findTagByIds(request.tags)
        val lectureTags = tags.map { LectureTag(lecture = lecture, tag = it) }.toList()

        lectureRepository.save(lecture)
        lectureTagRepository.saveAll(lectureTags)
    }

    @Transactional
    fun modifyLecture(lectureId: Long, request: LectureModifyRequest): LectureOneResponse {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        findLecture.update(request)

        lectureTagRepository.findTagByLecture(findLecture).map { it.delete() }
        val tags = tagRepository.findTagByIds(request.tags)
        val lectureTags = tags.map { LectureTag(lecture = findLecture, tag = it) }.toList()
        lectureTagRepository.saveAll(lectureTags)

        return findLecture.toOneResponse(lectureTags)
    }

    @Transactional
    fun deleteLecture(lectureId: Long) {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        findLecture.delete()
    }

    fun findOneLecture(lectureId: Long): LectureOneResponse {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)

        val lectureTags = lectureTagRepository.findTagByLecture(findLecture)
        return findLecture.toOneResponse(lectureTags)
    }

    fun findAllLecture(userId: Long): List<LectureListResponse> {
        val findUser = userRepository.findUserById(userId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_MEMBER)

        return lectureRepository
            .findAllByTeacher(findUser.id)
            .map { it.toListResponse() }
            .toList()
    }
}