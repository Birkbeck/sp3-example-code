package exercisesheet01.q8

sealed trait LinkedList[A] {
  def head: A

  def tail: LinkedList[A]

  def length: Int =
    this match {
      case Pair(hd, tl) => 1 + tl.length
      case Empty() => 0
    }

  def apply(index: Int): A =
    this match {
      case Pair(hd, tl) =>
        if (index == 0) hd
        else
          tl(index - 1)
      case Empty() =>
        throw new Exception("Attempted to get element from an Empty list")
    }
}

final case class Pair[A](head: A,  tail: LinkedList[A]) extends LinkedList[A]

final case class Empty[A]() extends LinkedList[A{

}

object Main extends App {
  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, Empty())))
  assert(list.isInstanceOf[LinkedList[Int]])

  assert(list.head == 1)


  //list.tail. // returns 2 as an Int
  //list.tail.tail
  // returns Pair(3, Empty()) as a LinkedList[Int]

  val example = Pair(1, Pair(2, Pair(3, Empty())))
  assert(example(0) == 1)
  assert(example(1) == 2)
  assert(example(2) == 3)
  assert(try {
    example(3) false
  } catch {
    case e: Exception => true
  })

}
