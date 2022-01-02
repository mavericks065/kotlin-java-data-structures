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
        while (currentNode != null) {
            if (currentNode.value == value) return true
            if (value > currentNode.value)
                currentNode = currentNode.right
            else
                currentNode = currentNode.left
        }
        return false
    }

    fun remove(value: Int) {
        if (root == null) return

        var currentNode = root
        var parentNode: Node? = null
        while (currentNode != null) {
            if (value > currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.right
            } else if (value < currentNode.value) {
                parentNode = currentNode
                currentNode = currentNode.left
            } else {
                if (currentNode.right == null) {
                    if (parentNode == null) {
                        root = currentNode.left
                    } else if (currentNode.value > parentNode.value) {
                        parentNode.right = currentNode.left
                    } else if (currentNode.value > parentNode.value) {
                        parentNode.right = currentNode.right
                    }
                } else if (currentNode.right!!.left == null) {
                    if (parentNode == null) {
                        this.root = currentNode.right
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right
                        }
                    }
                } else {
                    if (parentNode == null) {
                        val leftNode = this.root!!.left
                        val rightNode = this.root!!.right
                        this.root = currentNode.right!!.left
                        rightNode!!.left = rightNode.left!!.right
                        this.root!!.left = leftNode
                        this.root!!.right = rightNode
                    } else {
                        if (currentNode.value < parentNode.value) {
                            parentNode.left = currentNode.right!!.left
                        } else if (currentNode.value > parentNode.value) {
                            parentNode.right = currentNode.right!!.left
                        }
                    }
                }
                currentNode = null
            }
        }
    }

    // height is the number of nodes from a node to the lowest level in my case
    fun getHeight(node: Node?): Int {
        if (node == null)
            return 0
        else {
            var rightHeight = getHeight(node.right)
            var leftHeight = getHeight(node.left)
            if (rightHeight >= leftHeight)
                return rightHeight + 1
            else
                return leftHeight + 1
        }
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
    println("tree.lookup(21).toString()")
    println(tree.lookup(21).toString())
//    tree.remove(20)
//    println("tree after removal of 20")
//    println(tree.toString())
    println(tree.getHeight(tree.root))
    println(tree.getHeight(tree.root!!.left))
}
