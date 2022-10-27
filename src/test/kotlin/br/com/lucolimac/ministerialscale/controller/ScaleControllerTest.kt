package br.com.lucolimac.ministerialscale.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import javax.annotation.security.RunAs

@SpringBootTest
@ContextConfiguration(locations = ["classpath:test-config.xml"])
class ScaleControllerTest {
    @Test
    fun `Check sum is valid`() {
        Assertions.assertEquals(2 + 2, 4)
    }
}