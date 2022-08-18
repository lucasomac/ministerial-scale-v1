package br.com.lucolimac.ministerialscale.exceptions

import java.time.LocalDateTime

class MessageExceptionHandler(var timestamp: LocalDateTime, var status: Int, var message: String)