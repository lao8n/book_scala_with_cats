package sandbox

import cats.implicits.toShow
import cats.instances.string._
import cats.syntax.semigroup._
import cats.syntax.eq._ // for === and =!=
import cats.instances.option._

object Main extends App {
  println("Hello " |+| "Cats!")

  // Exercise 1.3 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-printable-library
  println("Exercise 1.3")
  val cat1 = Cat("elon", 5, "black")
  Printable.print(cat1)

  // Exercise 1.4.6 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-cat-show
  println("Exercise 1.4.6")
  val cat2 = CatShow("elon", 5, "white")
  println(cat2.show)

  // Exercise 1.5.5 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-equality-liberty-and-felinity
  println("Exercise 1.5.5")
  val cat3 = CatEq("Garfield", 38, "orange and black")
  val cat4 = CatEq("Heathcliff", 33, "orange and black")
  val optionCat3 = Option(cat3)
  val optionCat4 = Option.empty[CatEq]
  println(cat3 === cat4) // false
  println(cat3 =!= cat4) // true
  println(optionCat3 === optionCat4) // false
  println(optionCat3 =!= optionCat4) // true

  // Exercise 2.3 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-the-truth-about-monoids
  println("Exercise 2.3")
  println(BooleanMonoids.AndBoolean.combine(true, false)) // false
  println(BooleanMonoids.AndBoolean.combine(true, false)) // true
  println(BooleanMonoids.OrBoolean.combine(true, false)) // true
  println(BooleanMonoids.OrBoolean.combine(true, false)) // true

  // Exercise 2.4 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-all-set-for-monoids
}
