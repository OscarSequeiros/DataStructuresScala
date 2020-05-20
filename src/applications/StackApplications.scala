package applications

import stack.StackImpl

object StackApplications extends App {

  def checkParentheses(string: String): Boolean = {
    val stack = new StackImpl[Char]

    for (c <- string) {
      c match {
        case '(' => stack.push(c)
        case ')' => if (stack.isEmpty) return false else stack.pop()
        case _ =>
      }
    }
    stack.isEmpty
  }

  println(checkParentheses(")(((6)))"))
}
