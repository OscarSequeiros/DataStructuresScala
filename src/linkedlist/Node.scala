package linkedlist

case class Node[T](var value: T,
                   var next: Option[Node[T]] = None) {

  override def toString: String =
    if (next.nonEmpty) {
      s"$value -> ${next.get.toString}"
    } else {
      s"$value"
    }
}
