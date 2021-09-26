package au.com.nig.kotlin.linkedlist

class HomeMadeLinkedList<T>(value: T) {
    private var length: Int
    private var head: HomeMadeNode<T>
    private var tail: HomeMadeNode<T>

    init {
        this.head = HomeMadeNode(value)
        this.tail = HomeMadeNode(value)
        this.length = 1
    }

    fun append(newValue: T): HomeMadeLinkedList<T> {
        val previousTail = this.tail
        this.tail = HomeMadeNode(newValue)
        previousTail.next = this.tail

        if (head.next == null) {
            head.next = this.tail
        }

        length += 1
        return this
    }

    override fun toString(): String {
        return "HomeMadeLinkedList(length=$length, tail=$tail, head=$head)"
    }
}

fun main(args: Array<String>) {
    val fruitsLinkedList = HomeMadeLinkedList<String>("apple")

    println(fruitsLinkedList)
    fruitsLinkedList.append("pear")
    fruitsLinkedList.append("banana")
    println(fruitsLinkedList)
}
