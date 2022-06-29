package sandbox

trait MonadMap[F[_]] {
  def pure[A](a: A): F[A]
  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]
  def monadMap[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(a => pure(func(a)))
}

object MonadMap {
  implicit val pureOption: MonadMap[Option] =
    new MonadMap[Option] {
      override def pure[A](a: A): Option[A] = Option(a)

      override def flatMap[A, B](value: Option[A])(func: A => Option[B]): Option[B] =
        value match {
          case Some(v) => func(v)
          case None => None
        }
    }
}