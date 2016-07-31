/**
 * Created by Alvin on 7/30/2016.
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 18, 21, 6, 4};
        int sum = 10;
        subsetSum(array, sum, array.length);
    }

    public static void subsetSum(int[] array, int sum, int items) {
        boolean[][] subsetMatrix = new boolean[sum + 1][items + 1];
        for (int i = 0; i <= sum; i++) {
            subsetMatrix[i][0] = false;
        }
        for (int i = 0; i <= items; i++) {
            subsetMatrix[0][i] = true;
        }
        for (int i = 1; i <= items; i++) {
            for (int j = 1; j <= sum; j++) {
                subsetMatrix[i][j] = subsetMatrix[i - 1][j];
                if (subsetMatrix[i][j] == false && j >= array[i]) {

                }
            }
        }
    }
}
