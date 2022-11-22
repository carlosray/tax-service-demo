package com.example.demo.model.dto

data class ProductWithTaxDto(
    val id: Long,
    val price: Long,
    val tax: Long
)