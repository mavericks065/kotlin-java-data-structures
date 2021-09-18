package au.com.nig.kotlin.hashtable

object FirstRecurring {
    fun getFirstRecurringCharacter(input: Array<Int>): Int? {
        if (input == null || input.isEmpty()) {
            return null
        }
        val mapOfCharacters = hashMapOf<Int, Int>()
        for (i in input.indices) {
            val key = input[i]
            if (mapOfCharacters[key] == null)
                mapOfCharacters.put(key, 1)
            else
                return key
        }
        return null
    }
}
// https://github.com/satya-verma/Data-Structures-and-Algorithms--using-JAVA/blob/master/src/data_structures/hashtables/implementing_hashtable/HashTable.java
// https://github.com/nimrod46/Data-Structures-and-Algorithms/blob/master/src/data_structures/hash_tables/MyHashTable.java
// https://github.com/abdurakhmonoff/data-structures-and-algorithms-kotlin/blob/master/src/data_structures/hash_tables/implementation/HashTable.kt
