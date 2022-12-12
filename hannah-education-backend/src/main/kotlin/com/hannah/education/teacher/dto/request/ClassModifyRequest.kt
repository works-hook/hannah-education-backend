package com.hannah.education.teacher.dto.request

import java.time.LocalDate
import java.time.LocalTime

data class ClassModifyRequest(
    val title: String,
    val content: String,
)