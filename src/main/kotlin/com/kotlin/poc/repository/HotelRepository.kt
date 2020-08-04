package com.kotlin.poc.repository

import com.kotlin.poc.domain.Hotel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface HotelRepository : JpaRepository<Hotel, Long> {
    fun findByName(name: String): Optional<Hotel>
}