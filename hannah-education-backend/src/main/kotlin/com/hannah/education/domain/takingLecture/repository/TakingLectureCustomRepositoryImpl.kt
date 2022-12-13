package com.hannah.education.domain.takingLecture.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureTag.QLectureTag.lectureTag
import com.hannah.education.domain.tag.QTag.tag
import com.hannah.education.domain.takingLecture.QTakingLecture.takingLecture
import com.hannah.education.domain.takingLecture.TakingLecture
import com.hannah.education.domain.user.User
import com.hannah.education.student.dto.response.TagsByUserResponse
import com.querydsl.core.types.ConstructorExpression
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class TakingLectureCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
): TakingLectureCustomRepository {

    override fun findTakingLectureTagsByUser(user: User): List<TagsByUserResponse> {
        return queryFactory
            .select(tagsByUserResponse())
            .from(takingLecture)
            .join(lectureTag)
            .on(onLectureTag(), notDeleteLectureTag())
            .join(tag)
            .on(onTag(), notDeleteTag())
            .where(
                eqUser(user),
                notDelete(),
            )
            .groupBy(tag.id)
            .orderBy(tag.id.count().desc())
            .fetch()
    }

    override fun findTakingLectureByUser(user: User): List<TakingLecture> {
        return queryFactory
            .selectFrom(takingLecture)
            .where(
                eqUser(user),
                notDelete()
            )
            .fetch()
    }

    override fun findCountByLecture(lecture: Lecture): Long? {
        return queryFactory
            .select(takingLecture.count())
            .from(takingLecture)
            .where(
                eqLecture(lecture),
                notDelete()
            ).fetchOne()
    }

    private fun eqUser(user: User): BooleanExpression {
        return takingLecture.user.eq(user)
    }

    private fun eqLecture(lecture: Lecture): BooleanExpression {
        return takingLecture.lecture.eq(lecture)
    }

    private fun onTag(): BooleanExpression {
        return tag.id.eq(lectureTag.tag.id)
    }

    private fun onLectureTag(): BooleanExpression {
        return takingLecture.lecture.eq(lectureTag.lecture)
    }

    private fun notDelete(): BooleanExpression {
        return takingLecture.deletedDate.isNull
    }

    private fun notDeleteLectureTag(): BooleanExpression {
        return lectureTag.deletedDate.isNull
    }

    private fun notDeleteTag(): BooleanExpression {
        return tag.deletedDate.isNull
    }

    private fun tagsByUserResponse(): ConstructorExpression<TagsByUserResponse>? {
        return Projections.constructor(
            TagsByUserResponse::class.java,
            tag.id,
            tag.name,
            tag.color,
            tag.id.count()
        )
    }

}