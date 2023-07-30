package com.packt.cardatabase.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
data class Owner(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val ownerId:Long? = null,
  val firstName:String = "",
  val lastName:String = "",
  @JsonIgnore
  @OneToMany(cascade=[CascadeType.ALL], mappedBy="owner")
  val cars:List<Car> = listOf()
)