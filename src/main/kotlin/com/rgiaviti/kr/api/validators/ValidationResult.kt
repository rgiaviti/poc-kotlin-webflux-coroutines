package com.rgiaviti.kr.api.validators

import com.rgiaviti.kr.api.res.AppResponse
import com.rgiaviti.kr.api.res.MessageRes
import com.rgiaviti.kr.api.res.ResponseStatus


data class ValidationResult(
        val messages: MutableList<MessageRes> = mutableListOf()
) {
    fun hasErrors(): Boolean = this.messages.isNotEmpty()
    fun toAppResponse(status: ResponseStatus) = AppResponse(status, messages)
    fun toAppResponse(): AppResponse {
        return if (this.hasErrors()) {
            AppResponse(ResponseStatus.ERROR, messages)
        } else {
            AppResponse(ResponseStatus.SUCCESS, messages)
        }
    }

}