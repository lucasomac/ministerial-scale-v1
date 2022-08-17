package br.com.lucolimac.ministerialscale.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.sun.istack.NotNull
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Scale(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private val id: Long? = null,

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private val hour: LocalTime,

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private val date: LocalDate,

    @NotNull
    private val minister: String,

    @NotNull
    private val place: String
)