package sandbox

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) = monoid
}

object BooleanMonoids {
  implicit val AndBoolean: Monoid[Boolean] =
    new Monoid[Boolean]{
      def combine(x: Boolean, y: Boolean): Boolean = x && y
      def empty = false
    }

  implicit val OrBoolean: Monoid[Boolean] =
    new Monoid[Boolean]{
      def combine(x: Boolean, y: Boolean): Boolean = x || y
      def empty = false
    }

  implicit val XorBoolean: Monoid[Boolean] =
    new Monoid[Boolean]{
      def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (!x && y)
      def empty = false
    }

  implicit val XnorBoolean: Monoid[Boolean] =
    new Monoid[Boolean]{
      def combine(x: Boolean, y: Boolean): Boolean = (x && !y) && (!x && y)
      def empty = false
    }

}