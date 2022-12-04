package com.hannah.education.teacher.dto.request

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ClassModifyRequest(
    val title: String,
    val content: String,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val period: LocalDateTime,
    val isAssignment: Boolean,
    val assignmentContent: String?,
)