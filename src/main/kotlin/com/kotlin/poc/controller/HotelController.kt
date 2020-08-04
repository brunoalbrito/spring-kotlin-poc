package com.kotlin.poc.controller

import com.kotlin.poc.dto.CheckInDTO
import com.kotlin.poc.dto.HotelDTO
import com.kotlin.poc.service.HotelService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("hotels")
class HotelController(val hotelService: HotelService) {

    @GetMapping("/")
    fun findAll() = this.hotelService.findAll()

    @GetMapping("{name}")
    fun findByName(@PathVariable("name") name: String) = this.hotelService.findByName(name)

    @PostMapping("/checkin")
    fun checkIn(@RequestBody checkInRequest: CheckInDTO): HotelDTO = this.hotelService.checkIn(checkInRequest)

    @PostMapping("/checkout")
    fun checkOut(@RequestBody checkInRequest: CheckInDTO): HotelDTO = this.hotelService.checkOut(checkInRequest)

    @PostMapping
    fun create(@RequestBody hotelDTO: HotelDTO) = this.hotelService.create(hotelDTO)
}