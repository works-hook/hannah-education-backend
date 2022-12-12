package com.hannah.education.student.dto.response

import com.hannah.education.domain.banner.Banner

data class BannerResponse(
    val bannerId: Long?,
    val altText: String,
    val caption: String,
    val backgroundColor: String,
    val imageUrl: String,
)

fun Banner.toResponse(): BannerResponse = BannerResponse(
    bannerId = this.id,
    altText = this.altText,
    caption = this.caption,
    backgroundColor = this.backgroundColor,
    imageUrl = this.imageUrl
)
