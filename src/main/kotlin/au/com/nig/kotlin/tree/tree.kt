package au.com.nig.kotlin.tree

data class Node(val value: Int, var left: Node? = null, var right: Node? = null)

class BinarySearchTree {
    var root: Node? = null

    fun insert(value: Int) {
        val newNode = Node(value)
        if (root == null)
            root = newNode
        else {
            var currentNode = root
            while (true) {
                if (value >= currentNode!!.value) {
                    if (currentNode.right == null) {
                        currentNode.right = newNode
                        break
                    }
                    currentNode = currentNode.right
                } else {
                    if (currentNode.left == null) {
                        currentNode.left = newNode
                        break
                    }
                    currentNode = currentNode.left
                }
            }
        }
    }

    fun lookup(value: Int): Boolean {
        var currentNode = root
        while(true) {
            if (currentNode == null) return false
            if (currentNode.value == value) return true
            currentNode = if (value > currentNode.value)
                currentNode.right
            else
                currentNode.left
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
//    tree.remove(20)
//    println("tree after removal of 20")
//    println(tree.toString())
}
