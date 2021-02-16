package com.rgiaviti.kr.data.models

import com.rgiaviti.kr.api.req.movies.MovieReq
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("movies")
data class Movie(

        @Id
        val id: Int? = null,

        @Column("title")
        val title: String,

        @Column("director")
        val director: String,

        @Column("year")
        val year: String,

        @Column("metascore")
        val metascore: Int
) {
    companion object {
        fun valueOf(movieReq: MovieReq): Movie {
            return Movie(
                    title = movieReq.title!!,
                    director = movieReq.director!!,
                    year = movieReq.year!!,
                    metascore = movieReq.metascore!!
            )
        }
    }
}