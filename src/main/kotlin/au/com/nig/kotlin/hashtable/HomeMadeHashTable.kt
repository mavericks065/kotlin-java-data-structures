package au.com.nig.kotlin.hashtable

import java.util.*

fun main(args: Array<String>) {
    val myHashTable = HomeMadeHashTable<String, Int>(10)
    println(myHashTable)
    println(myHashTable.data.size)
    println(myHashTable.currentLength)

    myHashTable.set("NicolasG", 34)
    myHashTable.set("NicolasP", 33)
    myHashTable.set("Surya", 36)

    println(myHashTable.data.size)
    println(myHashTable.currentLength)
    println(myHashTable)

    println(myHashTable.get("NicolasG"))
    println(myHashTable.keys())
}

// TODO: would need a load factor and to optimize how to find when collisions

class HomeMadeHashTable<K, V>(size: Int) {
    var data: Array<LinkedList<HomeMadeKeyValue<K, V>>?>
    var currentLength: Int

    init {
        data = Array(size) { null }
        currentLength = 0
    }

    fun set(key: K, value: V) {
        val address = hash(key, data.size)
        var currentBucket: LinkedList<HomeMadeKeyValue<K, V>>? = data[address]
        if (currentBucket == null) {
            currentBucket = LinkedList()
        }
        currentBucket.addLast(HomeMadeKeyValue(key, value))
        data[address] = currentBucket
        currentLength += 1
    }

    fun get(key: K): V? {
        val address = hash(key, data.size)
        val currentBucket: LinkedList<HomeMadeKeyValue<K, V>>? = data[address]
        if (currentBucket.isNullOrEmpty())
            return null

        return currentBucket.find{ it.key == key }?.value // O(N)
    }

    fun keys(): Set<K> {
        val keys = mutableSetOf<K>()
        for (i in 0 until (data.size)) {
            if (!data[i].isNullOrEmpty()) {
                for (j in 0 until data[i]!!.size) {
                    keys.add(data[i]!![j].key)
                }
            }
        }
        return keys
    }

    override fun toString(): String {
        return "HomeMadeHashTable(data=${data.contentToString()}, currentLength=$currentLength)"
    }

    companion object {
        private fun hash(key: Any?, dataLength: Int): Int {
            val hash = if (key == null) 0 else key.hashCode() % dataLength
            return if (hash >= 0)
                hash
            else -1 * hash
        }
    }
}
