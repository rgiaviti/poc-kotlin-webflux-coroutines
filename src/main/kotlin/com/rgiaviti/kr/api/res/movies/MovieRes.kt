package com.rgiaviti.kr.api.res.movies

import com.fasterxml.jackson.annotation.JsonProperty
import com.rgiaviti.kr.data.models.Movie

data class MovieRes(

        @JsonProperty("title")
        val title: String?,

        @JsonProperty("director")
        val director: String?,

        @JsonProperty("year")
        val year: String?,

        @JsonProperty("metascore")
        val metascore: Int?
) {
    companion object {
        fun valueOf(movie: Movie): MovieRes {
            return MovieRes(
                    title = movie.title,
                    director = movie.director,
                    year = movie.year,
                    metascore = movie.metascore
            )
        }
    }
}