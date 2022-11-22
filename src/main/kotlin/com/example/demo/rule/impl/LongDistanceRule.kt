package com.example.demo.rule.impl

import com.example.demo.model.dto.DistanceDto
import com.example.demo.model.entity.Rule
import com.example.demo.rule.TaxRule
import org.springframework.stereotype.Component

@Component
class LongDistanceRule(override val name: String = "LONG_DISTANCE_RULE") : TaxRule {

    override fun apply(distance: DistanceDto, rule: Rule, price: Long): Long {
        val distanceFromConfig: Long = rule.config["long_distance"]?.toLongOrNull() ?: 0L

        return if (distance.distance >= distanceFromConfig) { rule.tax * price / 100 } else { 0 }
    }
}

