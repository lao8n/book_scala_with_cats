package sandbox

import cats.implicits.toShow
import cats.instances.string._
import cats.syntax.semigroup._
import cats.syntax.eq._ // for === and =!=
import cats.instances.option._

object Main extends App {
  println("Hello " |+| "Cats!")

  // Exercise 1.3 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-printable-library
  val cat1 = Cat("elon", 5, "black")
  Printable.print(cat1)

  // Exercise 1.4.6 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-cat-show
  val cat2 = CatShow("elon", 5, "white")
  println(cat2.show)

  // Exercise 1.5.5 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-equality-liberty-and-felinity
  val cat3 = CatEq("Garfield", 38, "orange and black")
  val cat4 = CatEq("Heathcliff", 33, "orange and black")
  val optionCat3 = Option(cat3)
  val optionCat4 = Option.empty[CatEq]
  println(cat3 === cat4)
  println(cat3 =!= cat4)
  println(optionCat3 === optionCat4)
  println(optionCat3 =!= optionCat4)
}
