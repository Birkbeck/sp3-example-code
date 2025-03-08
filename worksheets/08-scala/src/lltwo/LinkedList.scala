package lltwo

sealed trait LinkedList[A] {
  def length: Int =
    this match {
      case Pair(hd, tl) => 1 + tl.length
      case End() => 0
    }
}

final case class Pair[A](head: A, tail: LinkedList[A])
  extends LinkedList[A]

final case class End[A]() extends LinkedList[A]
