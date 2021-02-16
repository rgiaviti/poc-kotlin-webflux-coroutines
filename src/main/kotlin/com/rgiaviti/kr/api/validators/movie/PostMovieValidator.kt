package com.rgiaviti.kr.api.validators.movie

import com.rgiaviti.kr.api.req.movies.MovieReq
import com.rgiaviti.kr.api.res.MessageRes
import com.rgiaviti.kr.api.validators.AbstractRequestValidator
import com.rgiaviti.kr.api.validators.ValidationResult
import com.rgiaviti.kr.core.infra.messages.Dictionary
import com.rgiaviti.kr.core.infra.messages.MessageCode
import org.springframework.stereotype.Component

@Component
class PostMovieValidator(private val dictionary: Dictionary) : AbstractRequestValidator<MovieReq>() {

    override fun validateRequest(body: MovieReq): ValidationResult {
        val messages = this.validateRequiredFields(body)
        return ValidationResult(messages)
    }

    fun validateRequiredFields(movieReq: MovieReq): MutableList<MessageRes> {
        val messages = mutableListOf<MessageRes>()

        if (movieReq.title.isNullOrBlank()) {
            messages.add(this.dictionary.message(MessageCode.MOVIE_FIELD_TITLE_REQUIRED))
        }

        if (movieReq.director.isNullOrBlank()) {
            messages.add(this.dictionary.message(MessageCode.MOVIE_FIELD_DIRECTOR_REQUIRED))
        }

        if (movieReq.year.isNullOrBlank()) {
            messages.add(this.dictionary.message(MessageCode.MOVIE_FIELD_YEAR_REQUIRED))
        }

        if (movieReq.metascore == null) {
            messages.add(this.dictionary.message(MessageCode.MOVIE_FIELD_METASCORE_REQUIRED))
        }

        return messages;
    }


}