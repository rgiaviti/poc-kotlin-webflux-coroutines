package com.rgiaviti.kr.api.res

import com.fasterxml.jackson.annotation.JsonProperty

data class MessageRes(

        @JsonProperty("code")
        val code: String,

        @JsonProperty("message")
        val message: String
)
