package au.com.nig.kotlin.sorting

object Sorting {

    fun bubbleSort(numbers: MutableList<Int>): MutableList<Int> {
        for (loopCount in 1..numbers.size) {
            for (i in 0 until numbers.size - 1) {
                if (numbers[i] >= numbers[i + 1]) {
                    val temp0 = numbers[i]
                    val temp1 = numbers[i + 1]
                    numbers[i] = temp1
                    numbers[i + 1] = temp0
                }
            }
        }
        return numbers
    }

    fun selectionSort(numbers: MutableList<Int>): MutableList<Int> {
        for (loopCount in 0 until numbers.size - 1) {
            var currentMin = numbers[loopCount]
            for (i in loopCount until numbers.size) {
                if (currentMin > numbers[i]) {
                    val tempMin = currentMin
                    currentMin = numbers[i]
                    numbers[i] = tempMin
                }
            }
            numbers[loopCount] = currentMin
        }
        return numbers
    }


    fun insertionSort(numbers: MutableList<Int>): MutableList<Int> {
        for (idx in 0 until numbers.size) {
            if (numbers[idx] <= numbers[0]) {
                numbers.add(0, numbers.removeAt(idx))
            } else if (numbers[idx] < numbers[idx - 1]) {
                for (comparingIdx in 1 until idx) {
                    if (numbers[idx] < numbers[comparingIdx]) {
                        numbers.add(comparingIdx, numbers.removeAt(idx))
                        break
                    }
                }
            }
        }
        return numbers
    }

    fun mergeSort(numbers: MutableList<Int>): MutableList<Int> {
        if (numbers.isEmpty() || numbers.size == 1)
            return numbers

        val left = numbers.subList(0, numbers.size / 2)
        val right = numbers.subList(numbers.size / 2, numbers.size)

        return merge(mergeSort(left), mergeSort(right))
    }

    private fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
        val newList = mutableListOf<Int>()
        var leftIdx = 0
        var rightIdx = 0

        while(leftIdx < left.size && rightIdx < right.size) {
            if (left[leftIdx] < right[rightIdx]) {
                newList.add(left[leftIdx])
                leftIdx++
            } else {
                newList.add(right[rightIdx])
                rightIdx++
            }
        }
        val remainingLeft = left.subList(leftIdx, left.size)
        val remainingRight = right.subList(rightIdx, right.size)
        newList.addAll(remainingLeft)
        newList.addAll(remainingRight)

        return newList
    }

    fun quickSort(numbers: MutableList<Int>): MutableList<Int> {
        quickSortImplem(numbers, 0, numbers.size-1)
        return numbers
    }

    fun quickSortImplem(numbers: MutableList<Int>, first: Int, last: Int) {
        if (first < last) {
            val partitionIdx = reOrderAroundPivot(numbers, first, last)
            quickSortImplem(numbers, first, partitionIdx - 1)
            quickSortImplem(numbers, partitionIdx + 1, last)
        }
    }

    private fun reOrderAroundPivot(numbers: MutableList<Int>, first: Int, last: Int): Int {
        val pivotValue = numbers[last]
        var i = first - 1
        for (j in first until last) {
            if (numbers[j] < pivotValue) {
                i++
                val holdingValue = numbers[i]
                numbers[i] = numbers[j]
                numbers[j] = holdingValue
            }
        }
        val temp = numbers[i + 1]
        numbers[i + 1] = numbers[last]
        numbers[last] = temp
        return i + 1
    }

    fun bubbleSort0(numbers: MutableList<Int>): MutableList<Int> {

        for (index in 1..numbers.size) {
            var bubbleIndex = 0
            var nextToCompare = bubbleIndex + 1
            while (bubbleIndex < numbers.size - 1 && nextToCompare < numbers.size) {
                if (numbers[bubbleIndex] >= numbers[bubbleIndex + 1]) {
                    val temp0 = numbers[bubbleIndex]
                    val temp1 = numbers[nextToCompare]
                    numbers[bubbleIndex] = temp1
                    numbers[nextToCompare] = temp0
                    bubbleIndex++
                    nextToCompare++
                } else {
                    val temp0 = numbers[bubbleIndex]
                    val temp1 = numbers[nextToCompare]
                    numbers[bubbleIndex] = temp0
                    numbers[nextToCompare] = temp1
                    bubbleIndex = nextToCompare
                    nextToCompare++
                }
            }
        }
        return numbers
    }
}
