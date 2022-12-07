package com.hannah.education.common.tag.controller

import com.hannah.education.common.tag.service.TagService
import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.domain.tag.dto.TagResponse
import com.hannah.education.util.ApiResponse.Success
import com.hannah.education.util.code.SuccessCode
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture")
class TagController(
    private val tagService: TagService,
) {

    @NoToken
    @GetMapping("/tags")
    fun findAllTags(): Success<List<TagResponse>> {
        val result = tagService.findAllTags()
        return Success(result, SuccessCode.ALL_TAGS)
    }

    @NoToken
    @GetMapping("/tags-random")
    fun findRandomTags(): Success<List<TagResponse>> {
        val result = tagService.findRandomTags()
        return Success(result, SuccessCode.RANDOM_TAGS)
    }

}