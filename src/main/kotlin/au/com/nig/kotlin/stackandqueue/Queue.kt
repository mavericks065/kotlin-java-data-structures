package au.com.nig.kotlin.stackandqueue

data class NodeQueue<T>(val value: T, var next: NodeQueue<T>? = null)

class MyQueue<T> {
    private var first: NodeQueue<T>? = null
    private var last: NodeQueue<T>? = null
    private var length = 0

    fun peek(): T? {
        return if (first == null) null else first!!.value
    }

    fun enqueue(value: T) {
        val newNode = NodeQueue(value)
        if (length == 0) {
            first = newNode
            last = newNode
        } else {
            val holdingNode = last
            last = newNode
            holdingNode!!.next = this.last
        }

        length++
    }

    fun dequeue(): T? {
        if (first == null)
            return null
        if (first == last)
            last = null

        length--
        val holdingResult = first
        first = first!!.next
        return holdingResult!!.value
    }

    override fun toString(): String {
        return "MyQueue(first=$first, last=$last, length=$length)"
    }
}

fun main(args: Array<String>) {
    val queue = MyQueue<String>()

    queue.enqueue("customer 1")
    println(queue.toString())
    queue.enqueue("customer 2")
    println(queue.toString())
    queue.enqueue("customer 3")
    println(queue.toString())

    println("DEQUEUE 1")
    println(queue.dequeue())
    println(queue.toString())
    println("DEQUEUE 2")
    println(queue.dequeue())
    println(queue.toString())
    println("DEQUEUE 3")
    println(queue.dequeue())
    println(queue.toString())
    println("DEQUEUE 4")
    println(queue.dequeue())
    println(queue.toString())
}

