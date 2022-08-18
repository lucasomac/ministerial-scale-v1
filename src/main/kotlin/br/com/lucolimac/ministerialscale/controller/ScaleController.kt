package br.com.lucolimac.ministerialscale.controller


import br.com.lucolimac.ministerialscale.MinisterialScaleApplication
import br.com.lucolimac.ministerialscale.exceptions.ScaleNotFoundException
import br.com.lucolimac.ministerialscale.models.Scale
import br.com.lucolimac.ministerialscale.repository.ScaleRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate


@RestController
@RequestMapping("api/v1/scales")
class ScaleController(scaleRepository: ScaleRepository) {
    private val scaleRepository: ScaleRepository

    init {
        this.scaleRepository = scaleRepository
    }

    @GetMapping
    fun allScales(): MutableIterable<Scale?> {
        return scaleRepository.findAll()
    }

    @GetMapping(path = ["{id}"])
    fun findById(@PathVariable id: Long): ResponseEntity<Scale> {
        return scaleRepository.findById(id).map { record -> ResponseEntity.ok().body(record) }
            .orElseThrow { ScaleNotFoundException() }
    }

    @PostMapping
    fun create(@RequestBody scale: Scale): Scale {
        return scaleRepository.save(scale)
    }

    @PutMapping(value = ["{id}"])
    fun update(@PathVariable("id") id: Long, @RequestBody scale: Scale): ResponseEntity<Scale?>? {
        return scaleRepository.findById(id)
            .map { record ->
                val scaleToUpdate = scale.copy(id = record?.id)
                scaleRepository.save(scaleToUpdate)
                ResponseEntity.ok().body(scaleToUpdate)
            }.orElseThrow { ScaleNotFoundException() }
    }

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: Long): ResponseEntity<Any>? {
        return scaleRepository.findById(id)
            .map {
                scaleRepository.deleteById(id)
                ResponseEntity.ok().build<Any>()
            }.orElseThrow { ScaleNotFoundException() }
    }

    @GetMapping("byDate")
    fun findByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") date: LocalDate?): ResponseEntity<List<Scale?>>? {
        return scaleRepository.findByDate(date)?.map { record -> ResponseEntity.ok().body(record) }
            ?.orElse(ResponseEntity.notFound().build())
    }

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(MinisterialScaleApplication::class.java)
    }
}
