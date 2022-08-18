package br.com.lucolimac.ministerialscale

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class MinisterialScaleApplication

fun main(args: Array<String>) {
    val logger: Logger = LoggerFactory.getLogger(MinisterialScaleApplication::class.java)
    logger.info("Starting application...")
    runApplication<MinisterialScaleApplication>(*args)
    logger.info("The application is running!")
}
