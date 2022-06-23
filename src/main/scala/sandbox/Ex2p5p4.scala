package sandbox

import cats.Monoid
import cats.instances.int._ // for Monoid
import cats.syntax.semigroup._ // for |+|

object SuperAdder {
  def addList(items: List[Int]): Int = {
    items.foldLeft(Monoid[Int].empty)(_ |+| _)
  }

  implicit def add[A](items: List[A])(implicit monoid: Monoid[A]): A = {
    items.foldLeft(Monoid[A].empty)(_ |+| _)
  }
}

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val monoid: Monoid[Order] = new Monoid[Order] {
    def combine(o1: Order, o2: Order) =
      Order(
        o1.totalCost + o2.totalCost,
        o1.quantity + o2.quantity
      )

    def empty = Order(0, 0)
  }
}