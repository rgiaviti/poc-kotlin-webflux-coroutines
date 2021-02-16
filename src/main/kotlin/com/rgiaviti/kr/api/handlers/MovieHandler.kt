package com.rgiaviti.kr.api.handlers

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse

@Component
class MovieHandler {

    suspend fun createMovie(request: ServerRequest): ServerResponse {

        return ServerResponse.ok()
                .json()
                .bodyAndAwait(ProductStockView(product.await()!!, quantity.await()))
    }
}