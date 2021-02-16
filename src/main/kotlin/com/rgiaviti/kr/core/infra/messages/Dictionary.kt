package com.rgiaviti.kr.core.infra.messages

import com.rgiaviti.kr.api.res.MessageRes
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component


@Component
class Dictionary(private val messagesSource: MessageSource) {

    fun message(code: String, vararg args: Any): MessageRes {
        val message = messagesSource.getMessage(code, args, LocaleContextHolder.getLocale())
        return MessageRes(code, message)
    }
}