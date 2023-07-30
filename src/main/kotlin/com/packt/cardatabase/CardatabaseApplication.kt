package com.packt.cardatabase

import com.packt.cardatabase.domain.Car
import com.packt.cardatabase.domain.CarRepository
import com.packt.cardatabase.domain.Owner
import com.packt.cardatabase.domain.OwnerRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.transaction.Transactional

@EnableJpaRepositories
@SpringBootApplication
class CardatabaseApplication: CommandLineRunner {
	private val logger = LoggerFactory.getLogger(CardatabaseApplication::class.java)
	@Autowired
	private lateinit var  carRepository:CarRepository
	@Autowired
	private lateinit var ownerRepository:OwnerRepository

	@Transactional
	override fun run(vararg args: String?) {
		val owners = listOf(
			Owner(firstName = "John", lastName = "Johnson"),
			Owner(firstName = "Mary", lastName = "Robinson")
		)
		ownerRepository.saveAll(owners)
		val cars = listOf(
			Car(brand="Ford", model = "Mustang", registerNumber = "ADF-1111", year = 2021, price = 59000, owner = owners[0]),
			Car(brand="Nissan", model = "Leaf", registerNumber = "SSJ-3002", year = 2021, price = 29000, owner = owners[1]),
			Car(brand="Toyota", model = "Prius", registerNumber = "KKO-0212", year = 2021, price = 39000, owner = owners[1])
		)
		carRepository.saveAll(cars)
		val savedCars = carRepository.findAll()
		savedCars.forEach { logger.info(it.toString()) }
		val savedOwners = ownerRepository.findAll()
		savedOwners.forEach { logger.info(it.toString()) }
	}
}

fun main(args: Array<String>) {
	runApplication<CardatabaseApplication>(*args)
}
