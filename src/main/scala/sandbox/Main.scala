package sandbox

import cats.instances.string._
import cats.syntax.semigroup._

object Main extends App {
  println("Hello " |+| "Cats!")

  // Exercise 1.3 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-printable-library
  val cat = Cat("elon", 5, "black")
  Printable.print(cat)
}
