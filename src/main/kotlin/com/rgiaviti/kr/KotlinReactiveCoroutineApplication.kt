package com.rgiaviti.kr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class KotlinReactiveCoroutineApplication

fun main(args: Array<String>) {
	runApplication<KotlinReactiveCoroutineApplication>(*args)
}
