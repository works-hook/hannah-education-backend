package com.hannah.education.domain.user

enum class UserType {
    STUDENT {
        override fun isTeacher(): Boolean {
            return false
        }
    },
    TEACHER {
        override fun isTeacher(): Boolean {
            return true
        }
    };

    abstract fun isTeacher(): Boolean

}