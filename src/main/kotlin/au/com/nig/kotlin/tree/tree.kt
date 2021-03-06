package au.com.nig.kotlin.tree

import java.util.*

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

    fun breadthFirstSearch(): List<Int> {
        var currentNode = root
        val result = mutableListOf<Int>()
        val queueOfNodesToProcess = LinkedList<Node>()
        queueOfNodesToProcess.offer(currentNode)

        while (queueOfNodesToProcess.isNotEmpty()) {
            currentNode = queueOfNodesToProcess.pop()
            if (currentNode.left != null) {
                queueOfNodesToProcess.offer(currentNode.left)
            }
            if (currentNode.right != null) {
                queueOfNodesToProcess.offer(currentNode.right)
            }
            result.add(currentNode.value)
        }
        return result
    }

    fun breadthFirstSearchRecursive(): List<Int> {
        val queueOfNodesToProcess = LinkedList<Node>()
        queueOfNodesToProcess.offer(root!!)
        return bfsRecursive(queueOfNodesToProcess, mutableListOf())
    }

    fun bfsRecursive(queueOfNodeToProcess: LinkedList<Node>, finalResult: MutableList<Int>): List<Int> {
        if (queueOfNodeToProcess.isEmpty())
            return finalResult
        val currentNode = queueOfNodeToProcess.pop()
        if (currentNode.left != null)
            queueOfNodeToProcess.offer(currentNode.left)
        if (currentNode.right != null)
            queueOfNodeToProcess.offer(currentNode.right)
        finalResult.add(currentNode.value)
        return bfsRecursive(queueOfNodeToProcess, finalResult)
    }

    fun dfsInOrder(): List<Int> {
        return if (root == null)
            mutableListOf()
        else traverseInOrder(root!!, mutableListOf<Int>())
    }

    private fun traverseInOrder(node: Node, foundNodes: MutableList<Int>): List<Int> {
        if (node.left != null) traverseInOrder(node.left!!, foundNodes)
        foundNodes.add(node.value)
        if (node.right != null) traverseInOrder(node.right!!, foundNodes)
        return foundNodes
    }

    fun dfsPreOrder(): List<Int> {
        return if (root == null)
            mutableListOf()
        else traversePreOrder(root!!, mutableListOf<Int>())
    }

    private fun traversePreOrder(node: Node, foundNodes: MutableList<Int>): List<Int> {
        foundNodes.add(node.value)
        if (node.left != null) traversePreOrder(node.left!!, foundNodes)
        if (node.right != null) traversePreOrder(node.right!!, foundNodes)
        return foundNodes
    }

    fun dfsPostOrder(): List<Int> {
        return if (root == null)
            mutableListOf()
        else traversePostOrder(root!!, mutableListOf<Int>())
    }

    private fun traversePostOrder(node: Node, foundNodes: MutableList<Int>): List<Int> {
        if (node.left != null) traversePostOrder(node.left!!, foundNodes)
        if (node.right != null) traversePostOrder(node.right!!, foundNodes)
        foundNodes.add(node.value)
        return foundNodes
    }

    override fun toString(): String {
        return "BinarySearchTree(root=$root)"
    }
}
//     9
//  4     20
//1  6  15  170
/**
===== DFS - InOrder ===== From smallest to highest
[1, 4, 6, 9, 15, 20, 170]

===== DFS - PreOrder =====
[9, 4, 1, 6, 20, 15, 170]

===== DFS - PostOrder =====
[1, 6, 4, 15, 170, 20, 9]
 */
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

    println("======= Lookup of existing and unexisting nodes =====")
    println(tree.lookup(20).toString())
    println(tree.lookup(21).toString())
    println()

//    println("===== removal of 20 ==== ")
//    tree.remove(20)
//    println("tree after removal of 20")
//    println(tree.toString())
//    println()

    println("===== height ==== ")
    println(tree.getHeight(tree.root))
    println(tree.getHeight(tree.root!!.left))

    println()

    println("===== iterative BFS =====")
    println(tree.breadthFirstSearch().toString())

    println("===== iterative BFS recursive =====")
    println(tree.breadthFirstSearchRecursive().toString())

    println()

    println("===== DFS - InOrder =====")
    println(tree.dfsInOrder().toString())

    println()

    println("===== DFS - PreOrder =====")
    println(tree.dfsPreOrder().toString())

    println()

    println("===== DFS - PostOrder =====")
    println(tree.dfsPostOrder().toString())
}
