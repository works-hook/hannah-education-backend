package com.hannah.education.config.jwt

import com.hannah.education.util.code.ErrorCode
import com.hannah.education.util.exception.BusinessException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

@Component
class JwtTokenProvider {

    @Value("\${JWT_TOKEN_STRING}")
    private val jwtTokenString: String? = null
    private val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256

    fun generator(claims: Map<String, Any?>): String {
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
            .signWith(createKey())
            .compact()
    }

    fun validateJwt(jwt: String): Claims {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwtTokenString))
                .build()
                .parseClaimsJws(jwt)
                .body
        } catch (e: Exception) {
            throw BusinessException(ErrorCode.JWT_ERROR)
        }
    }

    private fun createKey(): Key {
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtTokenString)
        return SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)
    }

    companion object {
        const val JWT_TOKEN_VALIDITY = (24 * 60 * 60).toLong()
    }
}