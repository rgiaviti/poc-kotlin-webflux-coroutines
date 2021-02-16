package com.rgiaviti.kr.business.services

import com.rgiaviti.kr.api.req.movies.MovieReq
import com.rgiaviti.kr.api.res.AppResponse
import com.rgiaviti.kr.api.res.ResponseStatus
import com.rgiaviti.kr.api.res.movies.MovieRes
import com.rgiaviti.kr.core.infra.messages.Dictionary
import com.rgiaviti.kr.core.infra.messages.MessageCode
import com.rgiaviti.kr.data.models.Movie
import com.rgiaviti.kr.data.repositories.MovieRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait

@Service
class MovieService(
        private val dictionary: Dictionary,
        private val movieRepository: MovieRepository) {

    suspend fun createMovie(movieReq: MovieReq): ServerResponse {
        val foundMovies = this.movieRepository.findByTitleAndYear(movieReq.title!!, movieReq.year!!)
        if (foundMovies.isNotEmpty()) {
            val message = this.dictionary.message(MessageCode.MOVIE_ALREADY_EXISTS)
            return ServerResponse
                    .unprocessableEntity()
                    .bodyValueAndAwait(AppResponse(ResponseStatus.ERROR, mutableListOf(message)))
        }

        val newMovie = Movie.valueOf(movieReq)
        this.movieRepository.save(newMovie)
        return ServerResponse.ok().bodyValueAndAwait(AppResponse(status = ResponseStatus.SUCCESS))
    }

    suspend fun findAll(): ServerResponse {
        val movies = this.movieRepository.findAll().map { MovieRes.valueOf(it) }.toList()
        return ServerResponse.ok().bodyValueAndAwait(movies)
    }

    suspend fun findById(id: Int): ServerResponse {
        val movie = this.movieRepository.findById(id)
        return if (movie == null) {
            ServerResponse.notFound().buildAndAwait()
        } else {
            ServerResponse.ok().bodyValueAndAwait(movie)
        }
    }

    suspend fun findByYear(year: String): ServerResponse {
        val movies = this.movieRepository.findByYear(year)
        return ServerResponse.ok().bodyValueAndAwait(movies)
    }

    suspend fun findByTitleAndYear(title: String, year: String): ServerResponse {
        val movies = this.movieRepository.findByTitleAndYear(title, year)
        return ServerResponse.ok().bodyValueAndAwait(movies)
    }

    suspend fun findByDirector(director: String): ServerResponse {
        val movies = this.movieRepository.findByDirector(director)
        return ServerResponse.ok().bodyValueAndAwait(movies)
    }
}