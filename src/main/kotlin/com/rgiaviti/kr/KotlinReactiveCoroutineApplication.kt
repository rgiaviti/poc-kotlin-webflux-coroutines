package com.rgiaviti.kr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinReactiveCoroutineApplication

fun main(args: Array<String>) {
	runApplication<KotlinReactiveCoroutineApplication>(*args)
}
