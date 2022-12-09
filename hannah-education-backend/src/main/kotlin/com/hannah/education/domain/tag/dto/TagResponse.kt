package com.hannah.education.domain.tag.dto

import com.hannah.education.domain.tag.Tag

data class TagResponse(
    val id: Long?,
    val name: String,
    val color: String?,
    val imageUrl: String?,
)

fun Tag.toResponse(): TagResponse = TagResponse(
    id = this.id,
    name = this.name,
    color = this.color,
    imageUrl = this.imageUrl,
)
