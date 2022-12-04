package com.hannah.education.domain.tag.repository

import com.hannah.education.domain.tag.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository: JpaRepository<Tag, Long>, TagCustomRepository