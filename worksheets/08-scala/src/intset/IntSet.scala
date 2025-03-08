package intset

trait IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def append(other: IntSet): IntSet

  def union(other: IntSet): IntSet

  def intersect(other: IntSet): IntSet

  def excl(x: Int): IntSet

  def isEmpty: Boolean

  override def toString: String

  override def hashCode: Int

  override def equals(other: Any): Boolean
}

class EmptySet extends IntSet {
  override def contains(x: Int): Boolean = false

  override def incl(x: Int): IntSet =
    new NonEmptySet(x, new EmptySet, new EmptySet)

  override def append(other: IntSet): IntSet = other

  override def union(other: IntSet): IntSet = other

  override def intersect(other: IntSet): IntSet = this

  override def excl(x: Int): IntSet = this

  override def isEmpty: Boolean = true

  override def toString = "_,"

  override def hashCode = 0

  override def equals(other: Any) = {
    other.isInstanceOf[EmptySet]
  }
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet)
  extends IntSet {
  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this

  override def union(other: IntSet): IntSet = append(other)

  override def append(other: IntSet): IntSet = {
    val set = left.append(right.append(other))
    set.incl(elem)
  }

  override def intersect(other: IntSet): IntSet = {
    val l = left.intersect(other)
    val r = right.intersect(other)
    val s = l.union(r)
    if (other.contains(elem)) s.incl(elem) else s
  }

  override def excl(x: Int): IntSet = {
    if (x < elem) new NonEmptySet(elem, left.excl(x), right)
    else if (x > elem) new NonEmptySet(elem, left, right.excl(x))
    else left.append(right)
  }

  override def isEmpty: Boolean = false

  override def hashCode =
    elem + left.toString.length() - right.toString.length()

  override def equals(other: Any) = {
    other match {
      case that: NonEmptySet =>
        that.toString == toString
      case _ => false
    }
  }

  override def toString =
    left.toString + elem + "," + right.toString
}
