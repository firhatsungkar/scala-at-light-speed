package com.firhatsungkar

object FunctionalProgramming extends App {
  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I'm $age years old")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
      - Compose functions
      - Pass functions as args
      - return functions as result

     Conclusion: JVM use FunctionX in scala to implement functional programming
     FunctionX = Function1, Function2, ...
   */
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments an a string return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love ", "Scala") // "I love Scala"

  // Syntax Sugars
  // val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(4) // 8
  /*
    Equivalent to the much longer:
    new Function1[Int, Int] {
      override def apply(x: Int) = 2 * x
    }
   */
  // higher-order functions: take functions as args / return functions as results
  val aMappedList = List(1,2,3).map(x => x + 1) // HOF

  // val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  val aFlatMappedList = List(1,2,3).flatMap{ x =>
    List(x, 2 * x)
  } // alternative syntax

  // Filter
  // val aFilteredList = List(1,2,3,4,5).filter(x => x <= 3)
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3) //a

  // All pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter")) // sometimes difficult to read

  // for comprehensions
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map / flatmap chain above

//  println(allPairs)
  /**
    * Collection
    */

  // List
  val aList = List(1,2,3,4,5)
  val firstElement = aList.head
  val lastElement = aList.tail
  val aPrependList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // Sequences: list can be indexed
  val aSequence: Seq[Int] = Seq(1,2,3)
  val accessedElement = aSequence(1) // the element at index 1 -> 2

  // Vectors: fast Seq implementation
  // - Particular type of sequences which very fast for large data
  // - Has same method like sequences
  val aVector = Vector(1,2,3,4,5)

  // Set
  // Set of collection without duplicates
  val aSet = Set(1,2,3,3,3,4) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val anRemovedSet = aSet - 3 // Set(1,2,4,5)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(_ * 2).toList // List(2,4,..., 2000)
  println(twoByTwo.take(10))

  // Tuples = group of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // Map
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 123),
    ("Jane", 456)
  )

}
