package au.com.nig.kotlin.hashtable

class HomeMadeKeyValue<K, V>(val key: K, val value: V) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is HomeMadeKeyValue<*, *>) return false

        if (key != other.key) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key?.hashCode() ?: 0
        result = 31 * result + (value?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "HomeMadeKeyValue(key=$key, value=$value)"
    }
}
