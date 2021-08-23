package au.com.nig.java.array;

public class MergeArray {
    public static Integer[] mergeSortedArrays(Integer[] arr1, Integer[] arr2) {
        final Integer[] mergedArray = new Integer[arr1.length + arr2.length];
        int indexArr1 = 0;
        int indexArr2 = 0;
        for (int i = 0; i < mergedArray.length; i++) {
            if (indexArr1 < arr1.length && (indexArr2 == arr2.length || arr1[indexArr1] < arr2[indexArr2])) {
                mergedArray[i] = arr1[indexArr1];
                indexArr1++;
            } else {
                mergedArray[i] = arr2[indexArr2];
                indexArr2++;
            }
        }
        return mergedArray;
    }
}
