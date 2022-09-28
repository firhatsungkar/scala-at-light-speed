package com.firhatsungkar

object Basics extends App {
  // defining a value
  val meaningOfLife: Int = 34 // const int meaningOfLife = 42;

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  // String and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

 // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // in other languages meaningOfLife > 43 ? 56 : 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife > 43) 56
    else 0

  // code blocks
  val aCodeBlock = {
    // local definitions in the scoop
    val aLocalValue = 67

    // value of block is the value og the last expression
    aLocalValue + 3
  }


  // define a functions
  def myFunction(x: Int, y: String): String = y + " " + x
  def myOtherFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // In Scala we don't use loops or iteration, we use RECURSION!

  // The Unit type = no meaning value === "void" in other languages
  // type of SIDE EFFECTS
  println("I love scala")

  def myUnitReturningFunc(): Unit = {
    println("I don't love returning Unit")
  }

  val theUnit = ()
}
