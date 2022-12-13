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
    UPDATE_PASSWORD("00100", "비밀변호 변경이 완료되었습니다."),

    SECESSION("00006", "탈퇴가 정상적으로 처리되었습니다."),

    BANNER_LIST("00007", "메인 배너 리스트입니다."),
    TEACHER_LIST("00008", "메인 강사 리스트입니다."),

    LECTURE_CREATE("10001", "강의가 등록되었습니다."),
    LECTURE_MODIFY("10002", "강의가 수정되었습니다."),
    LECTURE_DELETE("10003", "강의가 삭제되었습니다."),

    ALL_LECTURE("10010", "강의 리스트입니다."),
    ONE_LECTURE("10011", "강의 상세입니다."),

    ALL_TAGS("10100", "태그 리스트입니다."),
    RANDOM_TAGS("10101", "랜덤 태그 리스트입니다."),

    TAKING_LECTURE("11000", "수강 신청이 정상 처리 되었습니다."),
    TAKING_LECTURE_LIST("11001", "수강중인 강의 리스트입니다."),
    LIKE_LECTURE("11002", "강의에 좋아요를 눌렀습니다."),
    CANCEL_LIKE_LECTURE("11005", "강의 좋아요를 취소했습니다."),
    LIKE_LECTURE_LIST("11003", "좋아요한 강의 리스트입니다."),
    TAKING_LECTURE_TAG("11004", "수강한 태그 리스트입니다."),

    ALL_NOTICE("20001", "강의 공지사항입니다."),
    NOTICE_CREATE("20002", "공지사항이 등록되었습니다."),
    NOTICE_MODIFY("20003", "공지사항이 수정되었습니다."),
    NOTICE_DELETE("20004", "공지사항이 삭제되었습니다."),
    ONE_NOTICE("20005", "공지사항 상세입니다."),

    CLASS_CREATE("10001", "수업이 등록되었습니다."),
    CLASS_MODIFY("10002", "수업이 수정되었습니다."),
    CLASS_DELETE("10003", "수업이 삭제되었습니다."),

    ALL_CLASS("10010", "수업 리스트입니다."),
    ONE_CLASS("10011", "수업 정보입니다."),

    ONE_TEACHER("10110", "강사 상세입니다."),

    SUCCESS_SAVE_IMAGE("10201", "이미지 저장이 완료되었습니다."),
    SUCCESS_DELETE_IMAGE("10202", "이미지 삭제가 완료되었습니다."),
}