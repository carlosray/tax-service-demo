package com.example.demo.service.impl

import com.example.demo.model.dto.DistanceDto
import com.example.demo.model.dto.DistancesDto
import com.example.demo.model.dto.InvoiceDto
import com.example.demo.service.DistanceService
import org.springframework.stereotype.Service

@Service
class DefaultDistanceService : DistanceService{
    override fun getDistances(invoice: InvoiceDto): List<DistancesDto> {
        return listOf(
            DistancesDto(
                invoice.products[0],
                listOf(
                    DistanceDto("Germany", 70),
                    DistanceDto("Austria", 30)
                )
            ),
            DistancesDto(
                invoice.products[1],
                listOf(
                    DistanceDto("Germany", 70),
                    DistanceDto("Austria", 30)
                )
            )
        )
    }
}