def isSafe(col: Int, queens: List[Int], delta: Int): Boolean =
  queens match {
    case Nil => true
    case List() => true
    case c :: rest =>
      c != col &&
        math.abs(c - col) != delta &&
        isSafe(col, rest, delta + 1)
  }