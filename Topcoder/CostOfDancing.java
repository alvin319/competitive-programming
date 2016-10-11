import java.util.Arrays;

/**
 * Created by qicodeng on 10/17/16.
 */
public class CostOfDancing {
    public static int minimum(int K, int[] danceCost) {
        Arrays.sort(danceCost);
        int total = 0;
        for (int i = 1; i <= K; i++) {
            total += danceCost[i - 1];
        }
        return total;
    }
}
