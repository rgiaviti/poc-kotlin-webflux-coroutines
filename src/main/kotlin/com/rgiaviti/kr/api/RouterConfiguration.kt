package com.rgiaviti.kr.api

import com.rgiaviti.kr.api.handlers.MovieHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouterConfiguration {

    @Bean
    fun moviesRoutes(movieHandler: MovieHandler) = coRouter {
        accept(APPLICATION_JSON).nest {
            POST("/movies", movieHandler::createMovie)
            GET("/movies", movieHandler::getMovies)
            GET("/movies/{id}", movieHandler::getMovieById)
            GET("/movies/year/{year}", movieHandler::getMovieByYear)
        }
    }
}