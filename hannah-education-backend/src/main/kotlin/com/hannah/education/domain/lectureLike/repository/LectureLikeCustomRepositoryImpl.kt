package com.hannah.education.domain.lectureLike.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lecture.QLecture.lecture
import com.hannah.education.domain.lectureLike.LectureLike
import com.hannah.education.domain.lectureLike.QLectureLike.lectureLike
import com.hannah.education.domain.user.User
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class LectureLikeCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): LectureLikeCustomRepository {

    override fun findCountByLecture(findLecture: Lecture): Long? {
        return queryFactory
            .select(lectureLike.count())
            .from(lecture)
            .join(lectureLike).on(lectureLike.lecture.eq(lecture))
            .where(
                eqLecture(findLecture)
            )
            .groupBy(lecture.id)
            .fetchOne()
    }

    override fun findLectureByUser(findUser: User): List<LectureLike> {
        return queryFactory
            .selectFrom(lectureLike)
            .where(
                eqUser(findUser),
                notDelete()
            )
            .fetch()
    }

    override fun checkLikedLectureByUser(user: User, lectureId: Long): Boolean {
        return queryFactory
            .selectFrom(lectureLike)
            .where(
                eqUser(user),
                eqLectureId(lectureId),
                notDelete()
            )
            .fetchOne()?.let { true } ?: false
    }

    override fun findLikeByAll(user: User, lecture: Lecture): LectureLike? {
        return queryFactory
            .selectFrom(lectureLike)
            .where(
                eqUser(user),
                eqLecture(lecture),
                notDelete()
            )
            .fetchOne()
    }

    private fun eqLecture(findLecture: Lecture): BooleanExpression {
        return lecture.eq(findLecture)
    }

    private fun eqUser(findUser: User): BooleanExpression {
        return lectureLike.user.eq(findUser)
    }

    private fun eqLectureId(lectureId: Long): BooleanExpression {
        return lectureLike.lecture.id.eq(lectureId)
    }

    private fun notDelete(): BooleanExpression {
        return lectureLike.deletedDate.isNull
    }

}