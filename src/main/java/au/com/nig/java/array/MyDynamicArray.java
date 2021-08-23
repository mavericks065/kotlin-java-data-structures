package au.com.nig.java.array;

import java.util.Arrays;

public class MyDynamicArray {
    private Object[] array;
    /**
     * max number of elements our array can have
     */
    private int capacity;
    /**
     * length of arrat
     */
    private int currentLength;

    public <T> MyDynamicArray() {
        capacity = 1;
        currentLength = 0;
        array = new Object[capacity];
    }

    /**
     * returns the element of array at the given index.
     * @param index
     * @return
     */
    public Object get(int index) {
        if (index >= 0 && index <= currentLength - 1)
            return this.array[index];
        else return new Exception("Index Out Of Bound");
    }

    /**
     * adds an element at the end
     * @param object
     */
    public void push(Object object) {
        // if currentLength becomes equal to capacity we need to increase the capacity to add more elements.
        if (currentLength == capacity) {
            Object[] tempArray = new Object[2 * capacity];
            for (int i = 0; i <= array.length - 1; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
            capacity = capacity * 2;
        }
        array[currentLength] = object;
        currentLength++;
    }

    /**
     * replaces value at given index with the newly entered value.
     * @param index
     * @param value
     */
    public void replace(int index, Object value) throws Exception {
        if (index >= 0 && index <= currentLength - 1) {
            array[index] = value;
        } else
            throw new Exception("Index out of bounds");
    }

    // remove last element
    public void pop() {
        if (currentLength > 0) {
            currentLength--;
        }
    }

    // delete element at the given index
    public void delete(int index) {
        if (index > -1 && index < currentLength) {
            if (index == currentLength - 1) {
                pop();
            } else {
                for (int i = index; i < currentLength; i++) {
                    array[i] = array[i + 1];
                }
                currentLength--;
            }
        } else {
            System.err.println("Index out of bounds");
        }
    }

    public Object[] getArray() {
        Object[] tempArr = new Object[currentLength];
        for (int i = 0; i < currentLength; i++) {
            tempArr[i] = array[i];
        }
        return tempArr;
    }


    public int length() {
        return currentLength;
    }

    public static void main(String[] args) throws Exception {
        MyDynamicArray groceryArray = new MyDynamicArray();
        groceryArray.push("apple");
        groceryArray.push("lemon");
        groceryArray.push("eggplant");
        System.out.println("Array-Length: " + groceryArray.length());
        System.out.println("array: " + Arrays.toString(groceryArray.getArray()));
        System.out.println("item at index 2: " + groceryArray.get(2));
        groceryArray.replace(1, "world");
        System.out.println("array: " + Arrays.toString(groceryArray.getArray()));
        groceryArray.pop();
        System.out.println("array: " + Arrays.toString(groceryArray.getArray()));
        groceryArray.delete(1);
        System.out.println("array: " + Arrays.toString(groceryArray.getArray()));
        System.out.println("Array-Length: " + groceryArray.length());
    }
}
