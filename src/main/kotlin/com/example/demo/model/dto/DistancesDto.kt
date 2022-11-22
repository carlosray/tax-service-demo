package com.example.demo.model.dto

data class DistancesDto(
    val productDto: ProductDto,
    val distances: List<DistanceDto>
)