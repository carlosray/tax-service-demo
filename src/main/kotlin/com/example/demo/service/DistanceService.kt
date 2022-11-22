package com.example.demo.service

import com.example.demo.model.dto.DistancesDto
import com.example.demo.model.dto.InvoiceDto

interface DistanceService {
    fun getDistances(invoice: InvoiceDto): List<DistancesDto>
}