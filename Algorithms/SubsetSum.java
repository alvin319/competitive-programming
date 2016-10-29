/**
 * Created by Alvin on 7/30/2016.
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 18, 21, 6, 4};
        int sum = 15;
        System.out.println(subsetSum(array, sum, array.length));
        System.out.println(subsetSum1D(array, sum));
    }

    public static boolean subsetSum(int[] array, int sum, int items) {
        boolean[][] subsetMatrix = new boolean[items + 1][sum + 1];
        for (int i = 0; i <= items; i++) {
            subsetMatrix[i][0] = true;
        }
        for (int i = 1; i <= items; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - array[i - 1] >= 0) { // Choosing this element and see if the remaining can be satisfied with previous set
                    subsetMatrix[i][j] = subsetMatrix[i - 1][j] || subsetMatrix[i - 1][j - array[i - 1]];
                } else { // Can't afford it, looking at previous sets for answers
                    subsetMatrix[i][j] = subsetMatrix[i - 1][j];
                }
            }
        }
        return subsetMatrix[items][sum];
    }

    public static boolean subsetSum1D(int[] array, int target) {
        boolean[] subset = new boolean[target + 1];
        subset[0] = true; // Empty set satisfies 0
        for (int i = 1; i <= array.length; i++) {
            for (int j = target; j >= array[i - 1]; j--) {
                subset[j] |= subset[j - array[i - 1]];
            }
        }
        return subset[target];
    }
}
