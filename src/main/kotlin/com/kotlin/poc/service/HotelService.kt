package com.kotlin.poc.service

import com.kotlin.poc.domain.Hotel
import com.kotlin.poc.dto.CheckInDTO
import com.kotlin.poc.dto.HotelDTO
import com.kotlin.poc.exception.HotelException
import com.kotlin.poc.repository.HotelRepository
import org.springframework.stereotype.Service


@Service
class HotelService(val hotelRepository: HotelRepository) {

    fun findAll(): Iterable<HotelDTO> {
        return this.hotelRepository.findAll().map { it.convertToDto() }
    }

    fun create(hotelDTO: HotelDTO): HotelDTO {
        return save(hotelDTO.convertToEntity())
    }

    fun findByName(name: String): HotelDTO {
        return this.hotelRepository
                .findByName(name)
                .map { it.convertToDto() }
                .orElseThrow { HotelException() }
    }

    fun checkIn(checkInRequest: CheckInDTO): HotelDTO {
        val hotel = findByName(checkInRequest)
        hotel.checkIn(checkInRequest.hotelGuest)
        return save(hotel)
    }

    private fun save(hotel: Hotel) = this.hotelRepository.save(hotel).convertToDto()

    fun checkOut(checkInRequest: CheckInDTO): HotelDTO {
        val hotel = findByName(checkInRequest)
        hotel.checkOut(checkInRequest.hotelGuest)
        return save(hotel)
    }

    private fun findByName(checkInRequest: CheckInDTO) =
            this.hotelRepository.findByName(checkInRequest.hotelName)
                                .orElseThrow { HotelException() }


}