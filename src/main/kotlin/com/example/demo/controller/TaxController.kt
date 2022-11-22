package com.example.demo.controller

import com.example.demo.model.dto.InvoiceDto
import com.example.demo.model.dto.TaxResponse
import com.example.demo.service.TaxService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tax")
class TaxController(
    private val taxService: TaxService
) {

    @PostMapping("calculate")
    fun calculate(@RequestBody invoice: InvoiceDto): TaxResponse = taxService.calculate(invoice)

}