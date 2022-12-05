package com.hannah.education.teacher.service.classTeacher

import com.hannah.education.domain.lecture.repository.LectureRepository
import com.hannah.education.domain.lectureClass.repository.LectureClassRepository
import com.hannah.education.teacher.dto.request.ClassCreateRequest
import com.hannah.education.teacher.dto.request.ClassModifyRequest
import com.hannah.education.teacher.dto.response.ClassResponse
import com.hannah.education.teacher.dto.response.toResponse
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ClassTeacherService(
    private val lectureRepository: LectureRepository,
    private val classRepository: LectureClassRepository,
) {

    @Transactional
    fun createClass(lectureId: Long, request: ClassCreateRequest) {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        val classSave = request.toClassEntity(findLecture)
        classRepository.save(classSave)
    }

    @Transactional
    fun modifyClass(classId: Long, request: ClassModifyRequest) {
        val findClass = classRepository.findClassById(classId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_CLASS)
        findClass.update(request)
    }

    @Transactional
    fun deleteClass(classId: Long) {
        val findClass = classRepository.findClassById(classId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_CLASS)
        findClass.delete()
    }

    fun findAllClass(lectureId: Long): List<ClassResponse> {
        val findLecture = lectureRepository.findLectureId(lectureId)
            ?: throw BusinessException(ErrorCode.NOT_EXIST_LECTURE)
        return classRepository
            .findClassAllByLecture(findLecture)
            .map { it.toResponse() }
    }

}