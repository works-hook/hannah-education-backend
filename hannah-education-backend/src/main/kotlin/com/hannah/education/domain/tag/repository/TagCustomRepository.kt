package com.hannah.education.domain.tag.repository

import com.hannah.education.domain.tag.Tag

interface TagCustomRepository {

    fun findTagByIds(ids: List<Long>): List<Tag>

}
