package sandbox

object SetMonoids {
  // because of A has to be a def not a val
  implicit def UnionSet[A]: Monoid[Set[A]] =
    new Monoid[Set[A]]{
      def combine(x: Set[A], y: Set[A]): Set[A] = x union y
      def empty = Set.empty[A]
    }

  // no identity implement
  implicit def IntersectionSet[A]: Semigroup[Set[A]] =
    new Semigroup[Set[A]]{
      def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
    }

  // FROM SOLUTIONS: set complement and set difference are not associative
  // however symmetric diff is (union - intersection)
  implicit def SymDiffMonoid[A]: Monoid[Set[A]] =
    new Monoid[Set[A]] {
      override def empty: Set[A] = Set.empty[A]
      override def combine(x: Set[A], y: Set[A]): Set[A] = (x diff y) union (y diff x)
    }
}