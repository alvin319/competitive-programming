import java.util.Arrays;

/**
 * Created by WiNDWAY on 9/10/15.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {-5, 9, 2, 6, -1, -1, 9, 18, 27, -5, 3, 4, -9, 2, 7, 16};
        int[] sortedArray = {-9, -7, -5, -3, 5, 6, 9, 10, 25, 34, 44, 66, 78, 99, 100, 101, 105};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    public static void merge(int[] array, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = array[start + i];
        }

        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = array[middle + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = start;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergeIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergeIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        for (int i = leftIndex; i < leftSize; i++) {
            array[mergeIndex] = leftArray[i];
            mergeIndex++;
        }

        for (int i = rightIndex; i < rightSize; i++) {
            array[mergeIndex] = rightArray[i];
            mergeIndex++;
        }
    }

}
