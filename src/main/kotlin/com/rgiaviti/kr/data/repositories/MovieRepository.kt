package com.rgiaviti.kr.data.repositories

import com.rgiaviti.kr.data.models.Movie
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository : CoroutineCrudRepository<Movie, Int> {

    suspend fun findByYear(year: String): List<Movie>
    suspend fun findByTitleAndYear(title: String, year: String): List<Movie>

    @Query("select * from movies m where upper(m.director) like '%upper(?0)%'")
    suspend fun findByDirector(director: String): List<Movie>


}