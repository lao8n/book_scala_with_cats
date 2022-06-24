package sandbox

trait InvariantCodec[A] {self =>
  def encode(value: A): String
  def decode(value: String): A
  def imap[B](dec: A => B, enc: B => A): InvariantCodec[B] =
    new InvariantCodec[B] {
      override def encode(value: B): String = self.encode(enc(value))
      override def decode(value: String): B = dec(self.decode(value))
    }
}

object InvariantCodec {
  def encode[A](value: A)(implicit c : InvariantCodec[A]): String =
    c.encode(value)
  def decode[A](value: String)(implicit c: InvariantCodec[A]): A =
    c.decode(value)

  implicit val stringCodec: InvariantCodec[String] =
    new InvariantCodec[String] {
      def encode(value: String): String = value
      def decode(value: String): String = value
    }
  implicit val intCodec: InvariantCodec[Int] =
    stringCodec.imap(_.toInt, _.toString)

  implicit val booleanCodec: InvariantCodec[Boolean] =
    stringCodec.imap(_.toBoolean, _.toString)

  implicit val doubleCodec: InvariantCodec[Double] =
    stringCodec.imap(_.toDouble, _.toString)

  implicit def boxCodec[A](implicit c: InvariantCodec[A]): InvariantCodec[Box[A]] =
    c.imap[Box[A]](Box(_), _.value)
}