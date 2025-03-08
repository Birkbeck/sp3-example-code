object OneSol {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(square(guess) - x) <= math.ulp(x)

  def square(x: Double) = x * x

  def abs(x: Double) = if (x > 0) x else -x

  def sqrt(x: Double) = sqrtIter(1.0, x)

  def main(args: Array[String]) {
    val x = sqrt(4)
    assert(x == 2)
  }
}