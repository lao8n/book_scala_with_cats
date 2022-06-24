package sandbox

trait PrintableContraMap[A] { self =>
  def format(value: A): String

  def contramap[B](func: B => A): PrintableContraMap[B] =
    new PrintableContraMap[B] {
      def format(value: B): String = {
        self.format(func(value))
      }
    }
}

final case class Box[A](value: A)

object PrintableContraMap{
  def format[A](value: A)(implicit p: PrintableContraMap[A]): String =
    p.format(value)

  implicit val stringPrintable: PrintableContraMap[String] =
    new PrintableContraMap[String] {
      def format(value: String): String =
        s"'${value}'"
    }

  implicit val booleanPrintable: PrintableContraMap[Boolean] =
    new PrintableContraMap[Boolean] {
      def format(value: Boolean): String =
        if(value) "yes" else "no"
    }

  // to get implicit PrintableContraMap need to make it a def not val
  implicit def boxPrintable[A](implicit p: PrintableContraMap[A]): PrintableContraMap[Box[A]] =
    p.contramap[Box[A]](_.value)
}