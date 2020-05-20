package stack

import java.util
import java.util.Collections

class StackImpl[Element] extends Stack[Element] {

  private val storage = new util.ArrayList[Element]()

  override def toString: String = {
    Collections.reverse(storage)
    val top = "--- top ---"
    var body = "\n"
    storage.forEach(x => body = body + x + "\n")
    val bottom = "---------"
    top + body + bottom
  }

  override def push(element: Element): Unit = storage.add(element)

  override def pop(): Option[Element] = {
    if (isEmpty)
      None
    else
      Option(storage.remove(storage.size() - 1))
  }

  override def peek(): Option[Element] = {
    if (isEmpty)
      None
    else
      Option(storage.get(storage.size() - 1))
  }

  override def count: Int = storage.size()
}

object StackImpl {

  def create[T](items: Iterable[T]): Stack[T] = {
    val stack = new StackImpl[T]
    items.foreach(x => stack.push(x))
    stack
  }

  def stackOf[Element](elements: Element*): Stack[Element] = {
    StackImpl.create(elements)
  }
}
