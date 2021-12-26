package au.com.nig.kotlin.tree

data class Node(val value: Int, var left: Node? = null, var right: Node? = null)

class BinarySearchTree {
    var root: Node? = null

    fun insert(value: Int) {
        return if (root == null) {
            root = Node(value)
        } else {
            var current = root!!
            while (true) {
                if (current.value >= value) {
                    if (current.left == null) {
                        current.left = Node(value)
                        break
                    }
                    current = current.left!!
                } else {
                    if (current.right == null) {
                        current.right = Node(value)
                        break
                    }
                    current = current.right!!
                }
            }
        }
    }

    fun lookup(value: Int): Boolean {
        if (root == null)
            return false

        var currentNode = root
        while(true) {
            if (currentNode == null) {
                return false
            }
            if (currentNode.value == value)
                return true
            else if (currentNode.value > value) {
                currentNode = currentNode.left
            } else if (currentNode.value < value) {
                currentNode = currentNode.right
            }
        }
    }

    fun remove(value: Int): Boolean {
        TODO()
    }

    fun traverse(node: Node): Node {
        val left = if (node.left == null) null else traverse(node.left!!)
        val right = if (node.right == null) null else traverse(node.right!!)
        val tree = Node(node.value, left, right)
        return tree;
    }

    override fun toString(): String {
        return "BinarySearchTree(root=$root)"
    }
}

fun main(args: Array<String>) {
    val tree = BinarySearchTree()
    tree.insert(9)
    tree.insert(4)
    tree.insert(6)
    tree.insert(20)
    tree.insert(170)
    tree.insert(15)
    tree.insert(1)
    println(tree.toString())

    println("tree.lookup(20).toString()")
    println(tree.lookup(20).toString())
    tree.remove(20)
    println("tree after removal of 20")
    println(tree.toString())
}
