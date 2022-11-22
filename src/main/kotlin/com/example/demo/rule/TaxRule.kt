package com.example.demo.rule

import com.example.demo.model.dto.DistanceDto
import com.example.demo.model.entity.Rule

interface TaxRule {
    val name: String

    fun apply(distance: DistanceDto, rule: Rule, price: Long): Long
}
