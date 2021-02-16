package com.rgiaviti.kr.api

import com.rgiaviti.kr.api.handlers.MovieHandler
import kotlinx.coroutines.FlowPreview
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @FlowPreview
    @Bean
    fun moviesRoutes(productsHandler: MovieHandler) = coRouter {
        POST("/movies", productsHandler::createMovie)
    }
}