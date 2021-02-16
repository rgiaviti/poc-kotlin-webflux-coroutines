package com.rgiaviti.kr.api.req.movies

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieReq(

        @JsonProperty("title")
        val title: String?,

        @JsonProperty("director")
        val director: String?,

        @JsonProperty("year")
        val year: String?,

        @JsonProperty("metascore")
        val metascore: Int?
)
