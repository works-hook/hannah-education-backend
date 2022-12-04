package com.hannah.education.student.dto.response

import com.hannah.education.domain.banner.Banner

data class BannerResponse(
    val title: String,
    val content: String,
    val backgroundColor: String,
    val imageUrl: String,
)

fun Banner.toResponse(): BannerResponse = BannerResponse(
    title = this.title,
    content = this.content,
    backgroundColor = this.backgroundColor,
    imageUrl = this.imageUrl
)
