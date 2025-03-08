abstract class Integer(n: Int) {
  final override def toString: String = n.toString

  def isZero: Boolean

  def isPositive: Boolean

  def predecessor: Integer

  def successor: Integer

  def +(that: Integer): Integer

  def -(that: Integer): Integer

  def negate: Integer
}

case class PosInt(last: Integer, n: Int) extends Integer(n: Int) {
  override def isZero: Boolean = false

  override def isPositive: Boolean = true

  override def predecessor: Integer = last

  override def successor: Integer = new PosInt(this, n + 1)

  override def +(that: Integer): Integer = last + that.successor

  override def -(that: Integer): Integer = last - that.predecessor

  override def negate: Integer = IntZero - this
}

case class NegInt(last: Integer, n: Int) extends Integer(n: Int) {
  override def isZero: Boolean = false

  override def isPositive: Boolean = false

  override def predecessor: Integer = new NegInt(this, n - 1)

  override def successor: Integer = last

  override def +(that: Integer): Integer = last + that.predecessor

  override def -(that: Integer): Integer = last - that.successor

  override def negate: Integer = IntZero - this
}

object IntZero extends Integer(0) {
  override def isZero: Boolean = true

  override def isPositive: Boolean = false

  override def predecessor: Integer = new NegInt(this, -1)

  override def successor: Integer = new PosInt(this, 1)

  override def +(that: Integer): Integer = that

  override def -(that: Integer): Integer = {
    def iter(n: Integer, p: Integer): Integer = {
      if (n.isZero) p
      else {
        val nextN = if (n.isPositive) n.predecessor else n.successor
        val nextP = if (n.isPositive) p.predecessor else p.successor
        iter(nextN, nextP)
      }
    }
    iter(that, this)
  }

  override def negate: Integer = this
}