import linkedlist.LinkedList

object Application extends App {

  println("Hello Scala")

  var linkedList = new LinkedList[Int]

  linkedList.append(1).append(2).append(3).append(4).append(5)
  println(s"list before operations: $linkedList")
  val node = linkedList.nodeAt(4)
  println(s"node at 3: $node")

  println(s"element removed: ${linkedList.removeAfter(node.get)} and list: $linkedList")
  println(s"list reversed: ${linkedList.reverse()}")

  linkedList.foreach(x => println(s"Double: ${x * 2}"))
}
