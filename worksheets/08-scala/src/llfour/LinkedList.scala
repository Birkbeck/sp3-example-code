package llfour

sealed trait LinkedList[A] {
  def apply(index: Int): A =
    this match {
      case Pair(hd, tl) =>
        if (index == 0) hd
        else
          tl(index - 1)
      case End() =>
        throw new Exception("Attempted to get element from an Empty list")
    }
}

final case class Pair[A](head: A, tail: LinkedList[A])
  extends LinkedList[A]

final case class End[A]() extends LinkedList[A]
