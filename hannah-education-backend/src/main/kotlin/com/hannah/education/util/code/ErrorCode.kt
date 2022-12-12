package com.hannah.education.util.code

enum class ErrorCode(
    val code: String,
    val message: String
) {
    JWT_ERROR("30000", "잘못된 토큰입니다."),

    NOT_URI("40000", "잘못된 URI 요청입니다."),
    NOT_BODY("40001", "잘못된 Body 요청입니다."),

    EXIST_ACCOUNT("40010", "이미 존재하는 닉네임입니다."),
    NOT_EXIST_MEMBER("40020", "존재하지 않은 사용자입니다."),
    NOT_MATCH_MEMBER("40030", "아이디 또는 비밀번호가 일치하지 않습니다."),

    NOT_MATCH_PASSWORD("40100", "비밀번호가 일치하지 않습니다."),

    NOT_EXIST_LECTURE("50001", "존재하지 않은 강의입니다."),
    NOT_EXIST_NOTICE("50002", "존재하지 않은 공지사항입니다."),

    NOT_EXIST_CLASS("50003", "존재하지 않은 수업입니다."),

    NOT_IMAGE_FORMAT("50500", "지원하지 않은 파일 형식입니다."),
    IMAGE_UPLOAD_ERROR("50501", "이미지를 업로드하던 중 에러가 발생했습니다."),
    IMAGE_REMOVE_ERROR("50502", "이미지를 삭제하던 중 에러가 발생했습니다."),
}