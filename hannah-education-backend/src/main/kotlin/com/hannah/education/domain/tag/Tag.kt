package com.hannah.education.domain.tag

import com.hannah.education.util.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Tag(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val color: String,
    val imageUrl: String?,
): BaseEntity()