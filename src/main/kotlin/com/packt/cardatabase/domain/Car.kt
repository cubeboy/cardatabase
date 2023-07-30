package com.packt.cardatabase.domain

import javax.persistence.*

@Entity
data class Car(
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  val id:Long? = null,
  val brand:String = "",
  val model:String = "",
  val registerNumber:String = "",
  val year:Int = 0,
  val price:Int = 0,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner")
  val owner:Owner? = null
)
