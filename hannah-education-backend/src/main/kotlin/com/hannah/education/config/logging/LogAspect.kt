package com.hannah.education.config.logging

import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder.currentRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.util.*

@Aspect
@Component
class LogAspect {

    private val logger = KotlinLogging.logger {}

    @Around("bean(*Controller)")
    fun controllerLogging(joinPoint: ProceedingJoinPoint): Any {
        val request = (currentRequestAttributes() as ServletRequestAttributes).request
        val response = (currentRequestAttributes() as ServletRequestAttributes).response

        var result: Any? = null
        val start = System.currentTimeMillis()
        return try {
            result = joinPoint.proceed(joinPoint.args)
            result
        } finally {
            val end = System.currentTimeMillis()
            logger.info("---------> Request: {} {} {}", request.method, request.requestURI, Arrays.toString(joinPoint.args))
            logger.info("---------> Response: {} {} ({}ms)", response?.status, result, end - start)
        }
    }
}