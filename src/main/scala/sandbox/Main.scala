package sandbox

import cats.instances.string._
import cats.syntax.semigroup._

object Main extends App {
  println("Hello " |+| "Cats!")

  // Exercise 1.3 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-printable-library
  val cat = Cat("elon", 5, "black")
  Printable.print(cat)

  // Exercise 1.4.6 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-cat-show
  val cat1 = CatShow("elon", 5, "black")
  println(cat1.show)
}
