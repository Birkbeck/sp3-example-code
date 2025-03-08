sealed trait IntTree

case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree

case class MyIntTree() {
  def contains(t: IntTree, v: Int): Boolean = t match {
    case EmptyTree => false
    case Node(e, _, _) if e == v => true
    case Node(e, l, _) if e < v => contains(l, v)
    case Node(e, _, r) => contains(r, v)
  }

  /*
  def contains(t: IntTree, v: Int): Boolean = t match {
    case EmptyTree => false
    case Node(elem: Int, left: IntTree, right: IntTree) =>
      if (v == elem) true
      else if (v < elem) contains(left, v)
      else contains(right, v)
  }
  */

  def insert(t: IntTree, v: Int): IntTree = t match {
    case EmptyTree => Node(v, EmptyTree, EmptyTree)
    case Node(elem: Int, left: IntTree, right: IntTree) =>
      if (v < elem) Node(elem, insert(left, v), right)
      else Node(elem, left, insert(right, v))
  }
}

case object EmptyTree extends IntTree

object Node {
  def apply(elem: Int, left: IntTree, right: IntTree) =
    new Node(elem, left, right)
}

// Note: There are two versions of the contains method, one of which
// featuring wildcard placeholders and pattern guards.
