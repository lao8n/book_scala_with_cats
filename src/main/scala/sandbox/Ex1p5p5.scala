package sandbox

import cats.Eq
import cats.instances.int._ // for int eq
import cats.instances.string._ // for string eq
import cats.syntax.eq._ // for === and =!=

final case class CatEq(name: String, age: Int, color: String)

object CatEq {
  implicit val catEq: Eq[CatEq] =
    Eq.instance[CatEq] {
      (cat1, cat2) =>
        cat1.age === cat2.age & cat1.name === cat2.name & cat1.color === cat2.name
    }
}
