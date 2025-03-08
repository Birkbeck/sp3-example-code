package llthree

sealed trait LinkedList[A] {
  def contains(item: A): Boolean =
    this match {
      case Pair(hd, tl) =>
        if (hd == item) true
        else
          tl.contains(item)
      case End() => false
    }
}

final case class Pair[A](head: A, tail: LinkedList[A])
  extends LinkedList[A]

final case class End[A]() extends LinkedList[A]
