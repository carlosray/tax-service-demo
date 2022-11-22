package com.example.demo.model.dto

import java.time.Instant

data class InvoiceDto(
    val id: Long,
    val from: Instant,
    val products: List<ProductDto>
)