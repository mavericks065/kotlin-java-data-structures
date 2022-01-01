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
