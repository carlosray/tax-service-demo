package com.example.demo.model.entity

import java.time.Instant

data class Rule(
    val id: Long,
    val country: String,
    val tax: Int,
    val name: String,
    val effectiveDate: Instant,
    val config: Map<String, String>
)