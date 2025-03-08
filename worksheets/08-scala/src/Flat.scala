def flattenLeft[A](xs: List[List[A]]): List[A] =
  ((Nil: List[A]) /: xs) {
    (xs, x) => xs ::: x
  }

def flattenRight[A](xs: List[List[A]]): List[A] =
  (xs :\ (Nil: List[A])) {
    (x, xs) => x ::: xs
  }