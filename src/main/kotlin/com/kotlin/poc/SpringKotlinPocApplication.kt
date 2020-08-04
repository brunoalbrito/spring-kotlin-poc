package com.kotlin.poc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinPocApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinPocApplication>(*args)
}
