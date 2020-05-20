import linkedlist.LinkedList
import stack.StackImpl

object Application extends App {

  val stack = StackImpl.stackOf(2, 3, 4)
  println(stack)

  val linkedList = new LinkedList[Int]
  linkedList.append(3)
  linkedList.append(6)
  linkedList.append(7)
  linkedList.append(8)

  linkedList.printInReverse()
}
