/**
 * Created by Alvin on 7/30/2016.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {-9, -7, -5, -3, 5, 6, 9, 10, 25, 34, 44, 66, 78, 99, 100, 101, 105};
        binarySearch(sortedArray, 0, sortedArray.length, -7);
    }

    public static int binarySearch(int[] array, int start, int end, int value) {
        if (start >= end) {
            System.out.println("Value is not in the array");
            return -1;
        }
        int middle = (start + end) / 2;
        if (array[middle] == value) {
            System.out.println("Index: " + middle + " Value: " + array[middle]);
            return middle;
        }
        return array[middle] > value ? binarySearch(array, 0, middle, value) : binarySearch(array, middle + 1, end, value);
    }
}
