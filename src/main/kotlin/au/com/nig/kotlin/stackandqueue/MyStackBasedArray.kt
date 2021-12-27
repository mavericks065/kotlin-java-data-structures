package au.com.nig.kotlin.stackandqueue

class MyStackBasedArray<T> {
    private val stackArr = mutableListOf<T>()
    private var length = 0

    fun peek(): T? {
        return if (length == 0) null else stackArr[length - 1]
    }

    fun push(value: T): MutableList<T> {
        stackArr.add(value)
        length++
        return stackArr
    }

    fun pop(): T? {
        return if (length == 0) null
        else {
            val result = stackArr.removeAt(length - 1)
            length--
            result
        }
    }

    override fun toString(): String {
        return "MyStackBasedArray(stackArr=$stackArr, length=$length)"
    }
}


fun main(args: Array<String>) {
    val stack = MyStackBasedArray<String>()

    stack.push("customer 1")
    println(stack.toString())
    stack.push("customer 2")
    println(stack.toString())
    stack.push("customer 3")
    println(stack.toString())
    println("1st POP")
    println(stack.pop())
    println(stack.toString())
    println("2nd POP")
    println(stack.pop())
    println(stack.toString())
    println("3rd POP")
    println(stack.pop())
    println(stack.toString())
    println("4th POP")
    println(stack.pop())
    println(stack.toString())
    println("5th POP")
    println(stack.pop())
    println(stack.toString())
}
