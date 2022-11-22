package com.example.demo.model.dto

data class TaxResponse(
    val invoice: Long,
    val products: List<ProductWithTaxDto>
)