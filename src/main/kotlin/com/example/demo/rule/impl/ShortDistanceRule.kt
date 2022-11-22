package com.example.demo.rule.impl

import com.example.demo.model.dto.DistanceDto
import com.example.demo.model.entity.Rule
import com.example.demo.rule.TaxRule
import org.springframework.stereotype.Component

@Component
class ShortDistanceRule(override val name: String = "SHORT_DISTANCE_RULE") : TaxRule {

    override fun apply(distance: DistanceDto, rule: Rule, price: Long): Long {
        val distanceFromConfig: Long = rule.config["short_distance"]?.toLongOrNull() ?: 0L

        return if (distance.distance < distanceFromConfig) { rule.tax * price / 100 } else { 0 }
    }
}

