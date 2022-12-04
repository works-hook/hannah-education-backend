package com.hannah.education.common.tag.service

import com.hannah.education.domain.tag.dto.TagResponse
import com.hannah.education.domain.tag.dto.toResponse
import com.hannah.education.domain.tag.repository.TagRepository
import org.springframework.stereotype.Service

@Service
class TagService(
    private val tagRepository: TagRepository
) {

    fun findAllTags(): List<TagResponse> {
        return tagRepository.findAll()
            .map { it.toResponse() }
    }

    fun findRandomTags(): List<TagResponse> {
        return tagRepository.findAll()
            .shuffled()
            .subList(0, 7)
            .map { it.toResponse() }
    }

}
