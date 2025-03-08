

object TailRec {
  val emptyProduct = 1

  def inefficientFactorial(n: Int): Int = {
    assert(n >= 0)

    if (n == 0) emptyProduct
    else n * inefficientFactorial(n - 1)
  }

  def factorial(n: Int): Int = {
    assert(n >= 0)

    @tailrec def factorial(n: Int, result: Int): Int =
      if (n == 0) result
      else factorial(n - 1, result * n)

    factorial(n, emptyProduct)
  }

  def main(args: Array[String]) {
    val result0 = factorial(5)
    val result1 = inefficientFactorial(5)

    assert(result0 == result1)
  }
}