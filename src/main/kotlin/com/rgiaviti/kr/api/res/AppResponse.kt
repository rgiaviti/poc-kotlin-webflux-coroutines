package com.rgiaviti.kr.api.res

import com.fasterxml.jackson.annotation.JsonProperty

enum class ResponseStatus {
    ERROR, SUCCESS
}

data class AppResponse(

        @JsonProperty("status")
        val status: ResponseStatus,

        @JsonProperty("messages")
        val messages: MutableList<MessageRes> = mutableListOf()
) {
    fun isError(): Boolean = this.status == ResponseStatus.ERROR
    fun isSuccess(): Boolean = this.status == ResponseStatus.SUCCESS
    fun addMessage(message: MessageRes) = this.messages.add(message)
    fun addMessage(code: String, message: String) = this.messages.add(MessageRes(code, message))
}
