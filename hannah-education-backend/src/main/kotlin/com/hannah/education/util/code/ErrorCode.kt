package com.hannah.education.util.code

enum class ErrorCode(
    val code: String,
    val message: String
) {
    NOT_URI("40000", "잘못된 URI 요청입니다."),
    NOT_BODY("40001", "잘못된 Body 요청입니다."),

    EXIST_ACCOUNT("40010", "이미 존재하는 닉네임입니다."),
    NOT_EXIST_MEMBER("40020", "존재하지 않은 사용자입니다."),
    NOT_MATCH_MEMBER("40030", "아이디 또는 비밀번호가 일치하지 않습니다."),

    NOT_MATCH_PASSWORD("40100", "비밀번호가 일치하지 않습니다."),
}