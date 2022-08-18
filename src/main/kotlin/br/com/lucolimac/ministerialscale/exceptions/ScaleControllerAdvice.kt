package br.com.lucolimac.ministerialscale.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime

@ControllerAdvice(basePackages = ["br.com.lucolimac.ministerialscaleapi.controller"])
class ScaleControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ScaleNotFoundException::class)
    fun scaleNotFound(): ResponseEntity<MessageExceptionHandler> {
        val error = MessageExceptionHandler(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Escala não encontrada!")
        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }
}