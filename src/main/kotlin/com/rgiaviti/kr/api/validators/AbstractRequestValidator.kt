package com.rgiaviti.kr.api.validators

abstract class AbstractRequestValidator<T> {

    abstract fun validateRequest(body: T): ValidationResult
}