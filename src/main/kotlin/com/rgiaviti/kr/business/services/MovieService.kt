package com.rgiaviti.kr.business.services

import com.rgiaviti.kr.api.req.movies.MovieReq
import com.rgiaviti.kr.api.res.AppResponse
import com.rgiaviti.kr.api.res.ResponseStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Service
class MovieService {

    suspend fun createMovie(movieReq: MovieReq): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(AppResponse(status = ResponseStatus.SUCCESS))
    }
}