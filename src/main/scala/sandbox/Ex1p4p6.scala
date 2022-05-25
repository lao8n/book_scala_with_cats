package sandbox

import cats.Show
import cats.instances.int._    // for Show
import cats.instances.string._ // for Show
import cats.syntax.show._ // for show

final case class CatShow(name: String, age: Int, color: String)

object CatShow {
  implicit val catShow: Show[CatShow] = Show.show[CatShow] {
    cat =>
      val name = cat.name.show
      val age = cat.age.show
      val color = cat.color.show
      s"$name is a $age year-old $color cat."
  }
}