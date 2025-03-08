

object TailProduct extends App {
  def linearProduct(a: Int, b: Int): Int =
    if (a > b) 1
    else a * linearProduct(a + 1, b)

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, result * f(a))
    }
    iter(a, 1)
  }

  def noOp(x: Int): Int = x

  assert(product(noOp)(2, 4) == linearProduct(2, 4))
  assert(product(noOp)(3, 6) == linearProduct(3, 6))
}