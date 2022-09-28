package com.firhatsungkar

object PatternMatching extends  App {

  // Switch Expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  println(order)

  // PM is an Expression

  // Case class decomposition
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a year old"
    case _ => "Something else"
  }
  println(personGreeting)

  // Tuples decomposition
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }
  println(bandDescription)

  // List decomposition
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List containing 2 on its second position"
    case _ => "unknown list"
  }
  println(listDescription)

  // if PM doesn't match anything it will throw a MatchError
  // PM will try all cases in sequence
}

