package com.hannah.education.domain.lecture.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lecture.QLecture.lecture
import com.hannah.education.domain.lectureLike.QLectureLike.lectureLike
import com.hannah.education.domain.takingLecture.QTakingLecture.takingLecture
import com.hannah.education.domain.user.QUser.user
import com.hannah.education.domain.user.User
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureCustomRepository {

    override fun findAllByTeacher(teacherId: Long?): List<Lecture> {
        return queryFactory
            .selectFrom(lecture)
            .where(
                eqUserId(teacherId),
                notDelete()
            )
            .orderBy(lecture.id.desc())
            .fetch()
    }

    override fun findLectureId(lectureId: Long): Lecture? {
        return queryFactory
            .selectFrom(lecture)
            .where(
                eqId(lectureId),
                notDelete()
            ).fetchOne()
    }

    override fun findMostTakenLectures(): List<Lecture> {
        return queryFactory.selectFrom(lecture)
            .join(takingLecture)
            .on(takingLecture.lecture.eq(lecture))
            .where(
                notDelete(),
                takingNotDelete()
            )
            .groupBy(lecture.id)
            .orderBy(takingLecture.count().desc())
            .fetch()
    }

    override fun findMostLikeLectures(): List<Lecture> {
        return queryFactory
            .selectFrom(lecture)
            .join(lectureLike)
            .on(lectureLike.lecture.eq(lecture))
            .where(
                notDelete(),
                likeNotDelete(),
            )
            .groupBy(lecture.id)
            .orderBy(lectureLike.count().desc())
            .fetch()
    }

    override fun findAllByStudent(): List<Lecture> {
        return queryFactory
            .selectFrom(lecture)
            .where(
                notDelete()
            )
            .orderBy(lecture.createdDate.desc())
            .fetch()
    }

    override fun findCountByTeacher(user: User): Long? {
        return queryFactory
            .select(lecture.count())
            .from(lecture)
            .where(
                eqUserId(user.id),
                notDelete()
            )
            .fetchOne()
    }

    private fun eqId(id: Long): BooleanExpression {
        return lecture.id.eq(id)
    }

    private fun eqUserId(id: Long?): BooleanExpression {
        return user.id.eq(id)
    }

    private fun notDelete(): BooleanExpression {
        return lecture.deletedDate.isNull
    }

    private fun likeNotDelete(): BooleanExpression {
        return lectureLike.deletedDate.isNull
    }

    private fun takingNotDelete(): BooleanExpression? {
        // return takingLecture.deleteDate.isNull
        return null
    }

}