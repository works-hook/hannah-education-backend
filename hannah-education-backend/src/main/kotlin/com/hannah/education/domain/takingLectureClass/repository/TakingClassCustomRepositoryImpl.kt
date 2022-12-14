package com.hannah.education.domain.takingLectureClass.repository

import com.hannah.education.domain.takingLectureClass.QTakingLectureClass.takingLectureClass
import com.hannah.education.domain.user.User
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class TakingClassCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
): TakingLectureClassCustomRepository {
//    override fun findDoneClassCountByUser(findUser: User): Long? {
//        return queryFactory
//            .select(takingLectureClass.lectureClass.count())
//            .from(takingLectureClass)
//            .where(
//                eqUser(findUser),
//                isDone(),
//                notDelete()
//            )
//            .fetchOne()
//    }
//
//    private fun eqUser(user: User): BooleanExpression {
//        return takingLectureClass.takingUser.eq(user)
//    }
//
//    private fun isDone(): BooleanExpression {
//        return takingLectureClass.done.isTrue
//    }
//
//    private fun notDelete(): BooleanExpression {
//        return takingLectureClass.deletedDate.isNull
//    }



}