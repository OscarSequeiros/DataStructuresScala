package stack

trait Stack[Element] {

  def push(element: Element)

  def pop(): Option[Element]

  def peek(): Option[Element]

  def count: Int

  def isEmpty: Boolean = count == 0
}
