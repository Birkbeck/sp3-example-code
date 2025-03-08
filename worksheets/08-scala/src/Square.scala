object Square extends App {
  def squareList(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => math.pow(y, 2).toInt :: squareList(ys)
  }

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => math.pow(x, 2).toInt)

  assert(squareList(List(1, 2, 3)) == List(1, 4, 9))
  assert(squareList2(List(1, 2, 3)) == List(1, 4, 9))
}