import scala.annotation.tailrec

trait AList[T] {
  val xs: List[T]

  def recursiveLength: Int = {
    @tailrec def iter(xs: List[T], acc: Int): Int = {
      xs match {
        case Nil => acc
        case x :: xs => iter(xs, acc + 1)
      }
    }

    iter(xs, 0)
  }
}

object Thing extends App {
  implicit def toAList[T](ys: List[T]) = new AList[T] {
    val xs = ys
  }

  assert(List().recursiveLength == 0)
  assert(List(1, -2).recursiveLength == 2)
  assert(List(1, 0, 3).recursiveLength == 3)
}

// The List class is sealed in Scala and thus cannot be extended.
// Therefore an implicit conversion is used to make the
// recursiveLength method available to the List instance.
