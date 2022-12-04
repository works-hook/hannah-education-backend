package com.hannah.education.util.code

enum class SuccessCode(
    val code: String,
    val message: String,
) {
    USER_REGISTER("00001", "회원 가입이 완료되었습니다."),

    NOT_DUPLICATE_ACCOUNT("00002", "사용 가능한 아이디입니다."),

    USER_MODIFY("00003", "회원 수정이 완료되었습니다."),

    USER_ONE("00004", "회원 상세입니다."),

    LOGIN("00005", "로그인이 완료되었습니다."),

    SECESSION("00006", "탈퇴가 정상적으로 처리되었습니다."),

    BANNER_LIST("00007", "메인 배너 리스트입니다."),
    TEACHER_LIST("00008", "메인 강사 리스트입니다."),
}