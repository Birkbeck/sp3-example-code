package ll

sealed trait LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A])
  extends LinkedList[A]
final case class End[A]() extends LinkedList[A]
