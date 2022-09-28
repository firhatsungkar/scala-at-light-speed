package com.firhatsungkar

object ObjectOrientation extends App {
  // By extending App it will provide main method that will execute body
  // java equivalent: public static void main(String[] args)

  // Class and Instance
  class Animal {
    // Define fields
    val age: Int = 0

    // Define methods
    def eat() = println("I'm easting")
  }
  val anAnimal = new Animal

  // Inheritance
  class Cat(val name: String) extends Animal // Construction definition

  val aCat = new Cat("Neko")

  // Constructor arguments are NOT fields
  // so need to put a val before the constructor argument

  aCat.name

  // Subtype polymorphism
  val aDeclaredAnimal: Animal = new Cat("Tom")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // Abstract Class
  abstract class WalkingAnimal {
    protected  val hasLegs = true // by default public, can restrict by adding keyword private / protected
    def walk(): Unit
  }

  // Interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // Single-Class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    override def ?!(thought: String): Unit = println(s"I was thinking about: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aCat)
  aCroc eat aDeclaredAnimal // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operator in Scala are actually method
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'm Dinosaur, I can eat anything.")
  }
  /*
    What you tell the compiler:
    class Carnivore_Anonymous_35728 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I'm Dinosaur, I can eat anything.")
    }
    val dinosaur = new Carnivore_Anonymous_35728
   */

  // Singleton Object
  object MySingleton {  // The only instance of MySingleton type
    val mySpecialValue = 1234567
    def mySpecialMethod(): Int = mySpecialValue
    def apply(x: Int): Int = x + 1 // Special apply method
  }

  MySingleton.mySpecialMethod()

  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  // Companion Object
  // = has the same name with defined class / trait

  object Animal {
    // companions can access each other's private fields / methods
    // singleton Animal and instances of Animal are different things

    val canLiveIndefinitely = true
  }

  val animalCanLiveForever = Animal.canLiveIndefinitely // "static" fields / methods

  /*
    Case Classes
    case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
   */
  case class Person(name: String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) // Person.apply("Bob", 54)


  // Exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // Generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // Using a generic with a concrete type
  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("A", "B", "C")

  /*
    Summary

      Point 1#: in scala we usually operate with IMMUTABLE values/objects
      - Any modification to an object must return ANOTHER object
        Benefit:
          1) works miracles in multithreaded / distributed env
          2) help making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW list

  /*
      Point 2#: Scala is closest to the Object Oriented ideal
   */
}
