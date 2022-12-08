package com.hannah.education.config.interceptor

import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class TokenInterceptor(
    private val tokenComponent: TokenComponent
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (handler !is HandlerMethod) return true
        handler.getMethodAnnotation(NoToken::class.java)?.let { return true }
        return tokenComponent.getClaimsCheck(request)
    }

}

