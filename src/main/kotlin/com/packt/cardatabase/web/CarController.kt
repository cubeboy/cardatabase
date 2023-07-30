package com.packt.cardatabase.web

import com.packt.cardatabase.domain.Car
import com.packt.cardatabase.domain.CarRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CarController(
  val carRepository: CarRepository
) {
  @RequestMapping("/cars")
  fun getCars(): Iterable<Car> {
    return carRepository.findAll()
  }
}