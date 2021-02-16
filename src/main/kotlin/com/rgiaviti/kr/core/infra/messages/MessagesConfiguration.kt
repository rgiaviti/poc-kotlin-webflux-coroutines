package com.rgiaviti.kr.core.infra.messages

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.i18n.LocaleContext
import org.springframework.context.i18n.SimpleLocaleContext
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver
import java.util.*
import java.util.Locale.LanguageRange.parse


@Configuration
class MessagesConfiguration : AcceptHeaderLocaleContextResolver(), WebFluxConfigurer {

    companion object {
        private const val LOCALE_QUERY_PARAM = "locale"
        private const val LOCALE_HEADER_PARAM = "Accept-Language"

        private const val PORTUGUESE_LANG = "pt"
        private const val ENGLISH_LANG = "en"

        private val LOCALES = listOf(Locale(PORTUGUESE_LANG), Locale(ENGLISH_LANG))
        private const val MESSAGES_PATH = "i18n/messages"
        private const val MESSAGE_FILE_ENCODING = "UTF-8"
    }

    override fun resolveLocaleContext(exchange: ServerWebExchange): LocaleContext {
        return SimpleLocaleContext(this.locale(exchange))
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource? {
        val rs = ResourceBundleMessageSource()
        rs.setBasename(MESSAGES_PATH)
        rs.setDefaultEncoding(MESSAGE_FILE_ENCODING)
        rs.setUseCodeAsDefaultMessage(true)
        return rs
    }

    private fun locale(exchange: ServerWebExchange): Locale {
        val acceptLanguageHeader = exchange.request.headers[LOCALE_HEADER_PARAM]
        val languageQueryParam = exchange.request.queryParams[LOCALE_QUERY_PARAM]

        if (acceptLanguageHeader != null && acceptLanguageHeader.isNotEmpty()) {
            return Locale.lookup(parse(acceptLanguageHeader.first()), LOCALES)
        }

        if (languageQueryParam != null && languageQueryParam.isNotEmpty()) {
            return Locale.lookup(parse(languageQueryParam.first()), LOCALES)
        }

        return Locale.getDefault()
    }
}