import scala.annotation.tailrec

object Operate {
  def operate(f: Int => Int)
             (oper: (Int, Int) => Int)
             (a: Int, b: Int, init: Int): Int = {
    @tailrec def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, oper(result, f(a)))
    }
    iter(a, init)
  }
}
