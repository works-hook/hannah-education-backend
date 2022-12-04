package com.hannah.education.domain.tag.repository

import com.hannah.education.domain.tag.QTag.tag
import com.hannah.education.domain.tag.Tag
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class TagCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
): TagCustomRepository {

    override fun findTagByIds(ids: List<Long>): List<Tag> {
        return queryFactory
            .selectFrom(tag)
            .where(
                inIds(ids),
                notDelete()
            ).fetch()
    }

    private fun inIds(ids: List<Long>): BooleanExpression {
        return tag.id.`in`(ids)
    }

    private fun notDelete(): BooleanExpression {
        return tag.deletedDate.isNull
    }

}