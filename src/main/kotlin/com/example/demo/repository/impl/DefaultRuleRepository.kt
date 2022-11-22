package com.example.demo.repository.impl

import com.example.demo.model.entity.Rule
import com.example.demo.repository.RuleRepository
import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
class DefaultRuleRepository : RuleRepository {
    override fun findAllRulesFrom(country: String, from: Instant): List<Rule> {
        return listOf(
            Rule(1, "Germany", 7, "SHORT_DISTANCE_RULE", Instant.now(), mapOf("short_distance" to "100")),
            Rule(2, "Germany", 19, "LONG_DISTANCE_RULE", Instant.now(), mapOf("long_distance" to "100")),

            Rule(1, "Austria", 9, "SHORT_DISTANCE_RULE", Instant.now(), mapOf("short_distance" to "100")),
            Rule(2, "Austria", 10, "LONG_DISTANCE_RULE", Instant.now(), mapOf("long_distance" to "100")),
        )
    }
}