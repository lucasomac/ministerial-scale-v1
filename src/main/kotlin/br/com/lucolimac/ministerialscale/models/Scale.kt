package br.com.lucolimac.ministerialscale.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Scale(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) val id: Long? = null,
    @JsonFormat(pattern = "HH:mm") val hour: LocalTime,
    @JsonFormat(pattern = "dd/MM/yyyy") val date: LocalDate,
    val minister: String,
    val place: String
)