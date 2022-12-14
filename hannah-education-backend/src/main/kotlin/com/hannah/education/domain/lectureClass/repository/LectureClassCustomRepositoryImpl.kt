package com.hannah.education.domain.lectureClass.repository

import com.hannah.education.domain.lecture.Lecture
import com.hannah.education.domain.lecture.QLecture.lecture
import com.hannah.education.domain.lectureClass.LectureClass
import com.hannah.education.domain.lectureClass.QLectureClass.lectureClass
import com.hannah.education.domain.takingLectureClass.QTakingLectureClass.takingLectureClass
import com.hannah.education.domain.takingLectureClass.TakingLectureClass
import com.hannah.education.domain.user.User
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

    override fun findClassCountByLecture(findLecture: Lecture): Long? {
        return queryFactory
            .select(lecture.count())
            .from(lectureClass)
            .where(
                eqLecture(findLecture),
                notDelete()
            ).fetchOne()
    }

    override fun findDoneClassCountByUser(findUser: User): Long? {
        return queryFactory
            .select(takingLectureClass.lectureClass.count())
            .from(takingLectureClass)
            .where(
                eqUser(findUser),
                isDone(),
                takingClassNotDelete()
            )
            .fetchOne()
    }

    override fun findTakingClassByUser(userId: Long, findLecture: Lecture): List<TakingLectureClass> {
        return queryFactory
            .selectFrom(takingLectureClass)
            .where(
                eqUserId(userId),
                eqClassLecture(findLecture),
                takingClassNotDelete(),
            )
            .fetch()
    }

    private fun eqUser(user: User): BooleanExpression {
        return takingLectureClass.takingUser.eq(user)
    }

    private fun eqUserId(userId: Long): BooleanExpression {
        return takingLectureClass.takingUser.id.eq(userId)
    }

    private fun eqClassLecture(lecture: Lecture): BooleanExpression {
        return takingLectureClass.lectureClass.lecture.eq(lecture)
    }

    private fun isDone(): BooleanExpression {
        return takingLectureClass.done.isTrue
    }

    private fun takingClassNotDelete(): BooleanExpression {
        return takingLectureClass.deletedDate.isNull
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