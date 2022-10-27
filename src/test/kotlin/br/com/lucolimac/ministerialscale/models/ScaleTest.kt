package br.com.lucolimac.ministerialscale.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalTime

class ScaleTest {
    @Test
    fun scaleTest() {
        val scale = Scale(1, LocalTime.MAX, LocalDate.MAX, "Luciano", "Matriz")
        assertEquals(LocalTime.MAX, scale.hour)
        println(scale.toString())
        assertTrue(scale.toString().contains("Scale("))
    }
}