package com.example.demo.service

import com.example.demo.model.dto.InvoiceDto
import com.example.demo.model.dto.TaxResponse

interface TaxService {
    fun calculate(invoice: InvoiceDto): TaxResponse
}