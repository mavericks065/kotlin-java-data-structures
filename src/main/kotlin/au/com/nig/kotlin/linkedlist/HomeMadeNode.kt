package au.com.nig.kotlin.linkedlist

class HomeMadeNode<T> {
    var value: T
    var next: HomeMadeNode<T>? = null

    constructor(value: T) {
        this.value = value
    }

    constructor(value: T, nextNode: HomeMadeNode<T>) {
        this.value = value
        this.next = nextNode
    }

    override fun toString(): String {
        return "HomeMadeNode(value=$value, next=$next)"
    }
}
