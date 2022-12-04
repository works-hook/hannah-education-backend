package com.hannah.education.domain.tag.dto

import com.hannah.education.domain.tag.Tag

data class TagResponse(
    val name: String,
    val imageUrl: String?,
)

fun Tag.toResponse(): TagResponse = TagResponse(
    name = this.name,
    imageUrl = this.imageUrl,
)
