object Sort extends App {
  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))

  def insert(x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => List(x)
      case y :: ys =>
        if (x <= y) x :: xs
        else y :: insert(x, ys)
    }
  }

  assert(isort(List(3, 5, 1)) == List(1, 3, 5))
}