package br.com.lucolimac.ministerialscale.repository

import br.com.lucolimac.ministerialscale.models.Scale
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface ScaleRepository : CrudRepository<Scale?, Long?> {
    fun findByDate(date: LocalDate?): Optional<List<Scale?>?>?
}