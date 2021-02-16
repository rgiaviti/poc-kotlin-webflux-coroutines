package com.rgiaviti.kr.api.res

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @JsonIgnore fun isError(): Boolean = this.status == ResponseStatus.ERROR
    @JsonIgnore fun isSuccess(): Boolean = this.status == ResponseStatus.SUCCESS
    @JsonIgnore fun addMessage(message: MessageRes) = this.messages.add(message)
    @JsonIgnore fun addMessage(code: String, message: String) = this.messages.add(MessageRes(code, message))
}
