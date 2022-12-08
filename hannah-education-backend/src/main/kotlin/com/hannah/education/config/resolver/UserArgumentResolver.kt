package com.hannah.education.config.resolver

import com.hannah.education.config.interceptor.NoToken
import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class UserArgumentResolver : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        val hasAnnotation = parameter.getParameterAnnotation(UserId::class.java) != null
        val isMatchType = parameter.parameterType == Long::class.java

        if (hasAnnotation && parameter.getMethodAnnotation(NoToken::class.java) != null) throw BusinessException(ErrorCode.JWT_ERROR)

        return hasAnnotation && isMatchType
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): Any? {
        return webRequest.getAttribute("userId", 0)
    }

}