

object TailSum extends App {
  val result0 = sum(noOp)(2, 4)
  val result1 = linearSum(2, 4)

  def linearSum(a: Int, b: Int): Int =
    if (a > b) 0
    else a + linearSum(a + 1, b)

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, result + f(a))
    }
    iter(a, 0)
  }

  def noOp(x: Int): Int = x

  assert(result0 == result1)
}