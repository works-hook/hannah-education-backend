package com.hannah.education.domain.lectureClass.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lectureClass.LectureClass
import com.hannah.education.domain.lectureClass.QLectureClass.lectureClass
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureClassCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
): LectureClassCustomRepository {

    override fun findClassById(classId: Long): LectureClass? {
        return queryFactory
            .selectFrom(lectureClass)
            .where(
                eqId(classId),
                notDelete(),
            )
            .fetchOne()
    }

    override fun findClassAllByLecture(lecture: Lecture): List<LectureClass> {
        return queryFactory
            .selectFrom(lectureClass)
            .where(
                eqLecture(lecture),
                notDelete(),
            )
            .fetch()
    }

    private fun eqLecture(lecture: Lecture): BooleanExpression {
        return lectureClass.lecture.eq(lecture)
    }

    private fun eqId(id: Long): BooleanExpression {
        return lectureClass.id.eq(id)
    }

    private fun notDelete(): BooleanExpression {
        return lectureClass.deletedDate.isNull
    }

}