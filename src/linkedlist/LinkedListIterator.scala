package linkedlist

class LinkedListIterator[T](list: LinkedList[T]) extends Iterator[T] {

  private var index = 0
  private var lastNode: Option[Node[T]] = None

  override def hasNext: Boolean = index < list.s

  override def next(): T = {
    if (index >= list.s) throw new IndexOutOfBoundsException

    lastNode = if (index == 0)
      list.nodeAt(0)
    else
      lastNode.flatMap(_.next)
    index += 1

    lastNode.get.value
  }
}
