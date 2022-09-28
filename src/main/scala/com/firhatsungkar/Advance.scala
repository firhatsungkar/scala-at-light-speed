package com.firhatsungkar

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advance extends App {
  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy.")
    43
  }
  // println not executed until it used

  val eagerValue = lazyValueWithSideEffect + 1
  // println executed

  // "pseudo-collections": Option, Try
  def methodWhichCanReturnNull(): String = "Hello, Scala"
  if (methodWhichCanReturnNull() == null) {
    // defensive code again null
  }
  // But in scala we don't do that (above),
  // instead we do:
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProccessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against this evil exception"
  }
  // But using too many try and catch will make code hard to read
  // instead we do:
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one
  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(exception) => s"I have obtained an exception: $exception"
  }

  /**
    * Evaluate something on another thread
    * (asynchronous programming)
    */
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value.")
    67
  })

  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap and filter

  /**
    * Implicits basics
    */
  // #1: Implicit arguments
  def aMethodWithImplicitArgs(implicit  arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: Implicit conversions
  implicit  class MyRichInteger(n: Int) {
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()
}
