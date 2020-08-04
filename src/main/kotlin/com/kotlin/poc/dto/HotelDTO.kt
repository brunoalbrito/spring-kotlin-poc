package com.kotlin.poc.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.kotlin.poc.domain.Hotel

@JsonInclude(JsonInclude.Include.NON_NULL)
class HotelDTO(val name: String, val classification: Int, val nbRooms: Int, val nbFreeRooms: Int?) {
    fun convertToEntity(): Hotel {
        return Hotel(this.name, this.classification, this.nbRooms)
    }

}
