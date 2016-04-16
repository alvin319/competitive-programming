/**
 * Created by WiNDWAY on 9/10/15.
 */
public class sortingPractice {
    public static void main(String[] args) {
        int[] array1 = {-5, 9, 2, 6, -1, -1, 9, 18, 27, -5, 3, 4, -5, 2, 7, 16};
        int[] sortedArray1 = {-9, -7, -5, -3, 5, 6, 9, 10, 25, 34, 44, 66, 78, 99, 100, 101, 105};
        beginMergesort(array1);
        binarySearch(sortedArray1, 0, sortedArray1.length, -7);
    }

    public static void beginMergesort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    public static void mergeSort(int[] array, int start, int end) {
        if(start < end) {
            int middle = (start + end + 1) / 2;
            System.out.println(middle);
            mergeSort(array, 0, middle);
            mergeSort(array, middle, end);
            merged(array, 0, middle, end);
        }
    }

    public static void merged(int[] array, int start, int middle, int end) {
        int firstEnd = middle;
        int secondEnd = end;
        int beginIndex = start;
        while(start < firstEnd && middle < secondEnd) {
            int firstValue = array[start];
            int secondValue = array[middle];
            if(firstValue > secondValue) {
                array[beginIndex] = secondValue;
                start++;
            } else {
                array[beginIndex] = firstValue;
                middle++;
            }
            beginIndex++;
        }
        for(int i = start; i < firstEnd; i++) {
            array[beginIndex] = array[i];
            beginIndex++;
        }
        for(int i = middle; i < secondEnd; i++) {
            array[beginIndex] = array[i];
            beginIndex++;
        }
    }

    public static int binarySearch(int[] array, int start, int end, int value) {
        if(start >= end) {
            System.out.println("Value is not in the array");
            return -1;
        }
        int middle = (start + end) / 2;
        if(array[middle] == value) {
            System.out.println("Index: " + middle + " Value: " + array[middle]);
            return middle;
        }
        else if(array[middle] > value)
            return binarySearch(array, 0, middle, value);
        return binarySearch(array, middle+1, end, value);
    }
}
