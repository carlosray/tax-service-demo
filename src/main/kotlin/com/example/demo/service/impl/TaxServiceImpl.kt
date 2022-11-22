package com.example.demo.service.impl

import com.example.demo.model.dto.InvoiceDto
import com.example.demo.model.dto.ProductWithTaxDto
import com.example.demo.model.dto.TaxResponse
import com.example.demo.repository.RuleRepository
import com.example.demo.rule.TaxRule
import com.example.demo.service.DistanceService
import com.example.demo.service.TaxService
import org.springframework.stereotype.Service

@Service
class TaxServiceImpl(
    private val distanceService: DistanceService,
    private val ruleRepository: RuleRepository,
    rules: List<TaxRule>
) : TaxService {

    private val rulesByName = rules.associateBy { it.name }

    override fun calculate(invoice: InvoiceDto): TaxResponse {
        val distances = distanceService.getDistances(invoice)

        val products = distances.map { d ->
            var tax = 0L
            val wholeDistance = d.distances.sumOf { it.distance }

            d.distances.forEach { distanceForProduct ->
                val rulesFrom = ruleRepository.findAllRulesFrom(distanceForProduct.country, invoice.from)
                rulesFrom.forEach {
                    val priceForDistance = distanceForProduct.distance * d.productDto.price / wholeDistance
                    tax += (rulesByName[it.name]?.apply(distanceForProduct, it, priceForDistance) ?: 0L)
                }
            }
            ProductWithTaxDto(
                d.productDto.id,
                d.productDto.price,
                tax
            )
        }

        return TaxResponse(invoice.id, products)
    }
}