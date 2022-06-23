package sandbox

import cats.Functor

sealed trait Tree[+A]
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]
object Tree {
  implicit val treeFunctor: Functor[Tree] = {
    new Functor[Tree] {
      def map[A, B](tree: Tree[A])(func: A => B): Tree[B] =
        tree match {
          case Leaf(value) => Leaf(func(value))
          case Branch(left, right) => Branch(map(left)(func), map(right)(func))
        }
    }
  }
  // o/w compiler can only find the functor instance for tree
  // not branch and leaf
  def branch[A](left: Tree[A], right: Tree[A]): Tree[A] =
    Branch(left, right)

  def leaf[A](value: A): Tree[A] =
    Leaf(value)
}
