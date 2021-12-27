package au.com.nig.kotlin.graph

data class MyGraph<T>(
    private val adjacentList: MutableMap<T, MutableList<T>> = mutableMapOf(),
    private var numberOfNodes: Int = 0
) {
    fun addVertex(node: T) {
        adjacentList[node] = mutableListOf()
        numberOfNodes++
    }

    fun addEdge(node1: T, node2: T) {
        if (adjacentList[node1] == null) addVertex(node1)
        if (adjacentList[node2] == null) addVertex(node2)
        if (!adjacentList[node1]!!.contains(node2))
            adjacentList[node1]!!.add(node2)

        if (!adjacentList[node2]!!.contains(node1))
            adjacentList[node2]!!.add(node1)
    }

    fun showConnections() {
        val keys: Set<T> = adjacentList.keys
        for (key in keys) {
            println("${key.toString()} --> ${adjacentList[key].toString()}")
        }
    }
}

fun main(args: Array<String>) {
    val graph = MyGraph<Int>()
    graph.addVertex(5)
    graph.addVertex(54)
    graph.addVertex(44)
    graph.addEdge(5, 54)
    graph.addEdge(5, 44)
    graph.showConnections()
}
