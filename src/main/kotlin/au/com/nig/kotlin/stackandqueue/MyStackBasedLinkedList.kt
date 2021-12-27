package au.com.nig.kotlin.stackandqueue

data class NodeStack(val value: String, var next: NodeStack? = null)

class MyStackBasedLinkedList {
    private var top: NodeStack? = null
    private var bottom: NodeStack? = null
    private var length = 0

    fun peek(): NodeStack? {
        return top
    }

    fun push(value: String): NodeStack? {
        if (length == 0) {
            bottom = NodeStack(value)
            top = NodeStack(value)
        } else {
            val newNode = NodeStack(value)
            var holdingNode = top
            top = newNode
            top!!.next = holdingNode
        }
        length++
        return top
    }

    fun pop(): NodeStack? {
        if (top == null) return null
        if (top == bottom)
            bottom = null

        length--
        val holdingResult = top
        top = top!!.next
        return holdingResult
    }

    override fun toString(): String {
        return "MyStack(top=$top, bottom=$bottom, length=$length)"
    }

}


fun main(args: Array<String>) {
    val stack = MyStackBasedLinkedList()

    stack.push("customer 1")
    println(stack.toString())
    stack.push("customer 2")
    println(stack.toString())
    stack.push("customer 3")
    println(stack.toString())
    println("1st POP")
    println(stack.pop())
    println(stack.toString())
    println("2nd POP")
    println(stack.pop())
    println(stack.toString())
    println("3rd POP")
    println(stack.pop())
    println(stack.toString())
    println("4th POP")
    println(stack.pop())
    println(stack.toString())
    println("5th POP")
    println(stack.pop())
    println(stack.toString())
}
