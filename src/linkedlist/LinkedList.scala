package linkedlist

class LinkedList[T] extends Iterable[T] {

  var h: Option[Node[T]] = None
  var t: Option[Node[T]] = None
  var s: Int = 0

  override def iterator: Iterator[T] = new LinkedListIterator[T](this)

  override def isEmpty = s == 0

  override def toString: String =
    if (isEmpty) "Empty list"
    else h.get.toString

  def push(element: T): LinkedList[T] = {
    h = Some(Node(element, h))
    if (t.isEmpty) t = h
    s += 1
    this
  }

  def append(element: T): LinkedList[T] = {
    if (isEmpty) push(element)
    else {
      t.get.next = Some(Node(element))
      t = t.get.next
      s += 1
      this
    }
  }

  def nodeAt(index: Int): Option[Node[T]] = {
    var currentNode = h
    var currentIndex = 0

    while (currentIndex < index && currentNode.isDefined) {
      currentNode = currentNode.get.next
      currentIndex += 1
    }
    currentNode
  }

  def insert(element: T, afterNode: Node[T]): Node[T] = {
    if (afterNode == t.get) {
      append(element)
      return t.get
    }
    val newNode = Node(element, afterNode.next)
    afterNode.next = Some(newNode)
    s += 1
    newNode
  }

  def pop(): Option[T] = {
    if (!isEmpty) s -= 1
    val result = h.get.value
    h = h.get.next

    if (isEmpty) t = null
    Option(result)
  }

  def removeLast(): Option[T] = {
    val newHead: Node[T] =
      if (h.isEmpty) return None
      else h.get

    if (newHead.next.isEmpty) return pop()
    s -= 1

    var prev = newHead
    var current = newHead
    var next = newHead.next

    while (next.isDefined) {
      prev = current
      current = next.get
      next = current.next
    }

    prev.next = None
    t = Some(prev)
    Some(current.value)
  }

  def removeAfter(node: Node[T]): Option[T] = {
    val result = node.next

    if (node.next == t) t = Some(node)

    if (node.next.isDefined) s -= 1

    node.next = node.next.flatMap(_.next)

    result.flatMap(option => Some(option.value))
  }

  def reverse(): LinkedList[T] = {
    var current = h
    var previous: Option[Node[T]] = None
    while (current.isDefined) {
      val next = current.flatMap(_.next)
      current.get.next = previous
      previous = current
      if (previous.flatMap(_.next).isEmpty) {
        t = previous
      }
      h = current
      current = next
    }
    this
  }
}
