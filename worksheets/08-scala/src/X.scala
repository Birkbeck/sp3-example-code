trait X {
  def incl(x: Int): Unit
}
case object Y extends X {
  override def incl(x: Int): Unit = {}
}

