package com.example.demo.repository

import com.example.demo.model.entity.Rule
import java.time.Instant

interface RuleRepository {
    fun findAllRulesFrom(country: String, from: Instant): List<Rule>
}