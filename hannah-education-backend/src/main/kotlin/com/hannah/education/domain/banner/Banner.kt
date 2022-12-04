package com.hannah.education.domain.banner

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Banner(
    @Id
    val id: Long? = null,
    val title: String,
    val content: String,
    val backgroundColor: String,
    val imageUrl: String,
)