package com.rgiaviti.kr.business.services

import com.rgiaviti.kr.api.req.movies.MovieReq
import com.rgiaviti.kr.api.res.AppResponse
import com.rgiaviti.kr.api.res.ResponseStatus
import com.rgiaviti.kr.api.res.movies.MovieRes
import com.rgiaviti.kr.data.repositories.MovieRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import java.util.stream.Collectors

@Service
class MovieService(private val movieRepository: MovieRepository) {

    suspend fun createMovie(movieReq: MovieReq): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(AppResponse(status = ResponseStatus.SUCCESS))
    }

    suspend fun findAll(): ServerResponse {
        val movies = this.movieRepository.findAll().map { MovieRes.valueOf(it) }.toList()
        return ServerResponse.ok().bodyValueAndAwait(movies)
    }
}