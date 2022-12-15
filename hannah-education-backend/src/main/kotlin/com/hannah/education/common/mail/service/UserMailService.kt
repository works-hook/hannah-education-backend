package com.hannah.education.common.mail.service

import com.hannah.education.util.redis.RedisUtils
import org.springframework.mail.MailSendException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import javax.mail.Message
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Service
class UserMailService(
    private val javaMailSender: JavaMailSender,
    private val redisUtils: RedisUtils,
) {

    fun sendMail(email: String) {
        val certificationNum: String = MailServiceUtils.certificationNum
        val message = getMessage(email, MailServiceUtils.certificationNum)
        redisUtils.setDataExpire(certificationNum, email)
        javaMailSender.send(message)
    }

    fun checkCertification(certificationNumber: String) {
        redisUtils.getData(certificationNumber)
            ?: throw MailSendException("인증번호가 잘못되었거나 인증 시간이 초과되었습니다. 다시 확인해주세요.");
    }

    private fun getMessage(email: String, certificationNumber: String): MimeMessage {
        return try {
            getMailMessage(email, certificationNumber)
        } catch (e: Exception) {
            throw MailSendException("관리자에게 문의해주세요.")
        }
    }

    private fun getMailMessage(email: String, certificationNumber: String): MimeMessage {
        val message = javaMailSender.createMimeMessage()
        message.addRecipient(Message.RecipientType.TO, InternetAddress(email))
        message.subject = "[hannah-education] 본인 인증 메일"
        message.setText(getText(certificationNumber), "UTF-8", "html")
        return message
    }

    private fun getText(certificationNum: String): String {
        return MailServiceUtils.START_CONTENT +
                certificationNum +
                MailServiceUtils.END_CONTENT
    }

}