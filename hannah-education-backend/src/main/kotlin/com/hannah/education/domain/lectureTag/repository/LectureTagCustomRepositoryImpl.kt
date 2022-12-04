package com.hannah.education.domain.lectureTag.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureTag.LectureTag
import com.hannah.education.domain.lectureTag.QLectureTag.lectureTag
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureTagCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureTagCustomRepository {

    override fun findTagByLecture(lecture: Lecture): List<LectureTag> {
        return queryFactory
            .selectFrom(lectureTag)
            .where(
                eqLecture(lecture),
                notDelete()
            ).fetch()
    }

    private fun eqLecture(lecture: Lecture): BooleanExpression {
        return lectureTag.lecture.`in`(lecture)
    }

    private fun notDelete(): BooleanExpression {
        return lectureTag.deletedDate.isNull
    }
}