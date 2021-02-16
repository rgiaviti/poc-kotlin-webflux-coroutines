package com.rgiaviti.kr.data.models

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("movies")
data class Movie(

        @Id
        val id: Int,
        val title: String,
        val director: String,
        val year: String,
        val metascore: Int
)