package com.kotlin.poc.domain

import com.kotlin.poc.dto.HotelDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hotel(private val name: String, private val classification: Int, private val nbRooms: Int) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0
    private var nbFreeRooms: Int = this.nbRooms

    fun checkIn(nbGuests: Int) {
        if (this.nbFreeRooms >= nbGuests) {
            this.nbFreeRooms -= nbGuests
        }
    }

    fun checkOut(nbGuests: Int) {
        this.nbFreeRooms += nbGuests
    }

    fun convertToDto(): HotelDTO {
        return HotelDTO(this.name, this.classification, this.nbRooms, this.nbFreeRooms)
    }
}