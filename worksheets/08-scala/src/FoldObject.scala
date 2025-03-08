object FoldObject extends App {
  val xs: List[Int] = List(1, 2, 3)

  def mapFun[A, B](xs: List[A], f: A => B): List[B] =
    (xs :\ List[B]()) {
      (x, xs) => f(x) :: xs
    }

  def lengthFun[A](xs: List[A]): Int =
    (0 /: xs) {
      (sum, _) => sum + 1
    }

  def f(x: Int): Int = math.pow(x, 2).toInt

  assert(lengthFun(xs) == 3)
  assert(mapFun(xs, f) == List(1, 4, 9))
}