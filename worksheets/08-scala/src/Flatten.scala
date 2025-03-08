object Flatten extends App {
  val xss = List(List(1, 2), List(3, 4))

  def flattenOrg[A](xss: List[List[A]]): List[A] =
    (xss :\ (Nil: List[A])) ((xs, ys) => xs ::: ys)

  def flatten[A](xss: List[List[A]]): List[A] =
    for (xs <- xss; x <- xs) yield x

  assert(flatten(xss) == flattenOrg(xss))
}
