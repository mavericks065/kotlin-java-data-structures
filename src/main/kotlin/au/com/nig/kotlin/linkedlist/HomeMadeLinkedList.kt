package au.com.nig.kotlin.linkedlist

class HomeMadeLinkedList<T> {
    private var length: Int
    private var tail: HomeMadeNode<T>
    private var head: HomeMadeNode<T>

    constructor(value: T) {
        this.head = HomeMadeNode(value)
        this.tail = HomeMadeNode(value)
        this.length = 1
    }

    override fun toString(): String {
        return "HomeMadeLinkedList(length=$length, tail=$tail, head=$head)"
    }
}

fun main(args: Array<String>) {
    val fruitsLinkedList = HomeMadeLinkedList<String>("apple")

    println(fruitsLinkedList)
}
