package sandbox

import PrintableInstances._

trait Printable[A] {
  def format(value : A): String
}

object PrintableInstances {
  implicit val pString : PrintableContraMap[String] =
    new PrintableContraMap[String] {
      def format(value: String): String =
        value
    }

  implicit val pInt : PrintableContraMap[Int] =
    new PrintableContraMap[Int] {
      def format(value: Int): String =
        value.toString()
    }
}

object Printable {
  def format[A](value : A)(implicit p: PrintableContraMap[A]): String = {
    p.format(value)
  }
  def print[A](value: A)(implicit p: PrintableContraMap[A]): Unit = {
    println(format(value))
  }
}

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catPrintable = new PrintableContraMap[Cat] {
    def format(cat: Cat): String = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }
}