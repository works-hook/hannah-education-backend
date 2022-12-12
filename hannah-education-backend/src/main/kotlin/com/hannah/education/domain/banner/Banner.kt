package com.hannah.education.domain.banner

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Banner(
    @Id
    val id: Long? = null,
    val altText: String,
    val caption: String,
    val backgroundColor: String,
    val imageUrl: String,
)