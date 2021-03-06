package sandbox

import cats.implicits.toShow
import cats.instances.string._
import cats.syntax.semigroup._
import cats.syntax.eq._
import cats.instances.option._
import cats.instances.int._
import cats.syntax.functor._

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
  println("Exercise 2.4")
  println(SetMonoids.UnionSet.combine(Set("1", "2"), Set("2", "3")))
  println(SetMonoids.IntersectionSet.combine(Set("1", "2"), Set("2", "3")))

  // Exercise 2.5.4 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-adding-all-the-things
  println("Exercise 2.5.4")
  println(SuperAdder.addList(List(3, 2, 4)))
  println(SuperAdder.add(List(3, 2, 4)))
  println(SuperAdder.add(List(Some(1), None, Some(2), Some(3))))
  println(SuperAdder.add(List(Order(3.5, 2.0), Order(1, 4))))

  // Exercise 3.5.4 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-branching-out-with-functors
  println("Exercise 3.5.4")
  println(Tree.leaf(100).map(_ * 2))
  println(Tree.branch(Tree.leaf(10), Tree.leaf(20)).map(_ * 2))

  // Exercise 3.5.5.1 https://www.scalawithcats.com/dist/scala-with-cats.html#contravariant
  println(PrintableContraMap.format("hello"))
  println(PrintableContraMap.format(true))
  println(PrintableContraMap.format(Box("hello world")))
  println(PrintableContraMap.format(Box("hello world")))

  // Exercise 3.5.6.1 https://www.scalawithcats.com/dist/scala-with-cats.html#sec:functors:invariant
  println(InvariantCodec.encode(5))
  println(InvariantCodec.encode("hello"))
  println(InvariantCodec.encode(false))
  println(InvariantCodec.encode(123.4))
  println(InvariantCodec.encode(Box(123.4)))
  println(InvariantCodec.decode[Int]("5"))
  println(InvariantCodec.decode[String]("hello"))
  println(InvariantCodec.decode[Boolean]("false"))
  println(InvariantCodec.decode[Double]("123.4"))
  println(InvariantCodec.decode[Box[Double]]("123.4"))

  // Exercise 4.1.2 https://www.scalawithcats.com/dist/scala-with-cats.html#exercise-getting-func-y
  println(Some(3).map(x => x + 1))
  // println(None.map(x => x + 1))
}
