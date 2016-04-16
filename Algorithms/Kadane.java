/**
 * Created by WiNDWAY on 3/18/16.
 */
public class Kadane {
    public static void main(String[] args) {
        int[] array = {1, 2, -3, 4, -1, 2, -6};
        int[] cache = new int[array.length + 1];
        int maxStart = -1;
        int maxEnd = -1;
        int currentStart = 0;
        int currentEnd = 0;
        int currentProfit = 0;
        int j = 1;
        for (int i = 0; i < array.length; i++) {
            currentProfit += array[i];
            currentEnd = i;
            if(currentProfit >= cache[j - 1]) {
                maxEnd = currentEnd;
                maxStart = currentStart;
            }
            if(currentProfit <= 0) {
                currentProfit = 0;
                currentStart = i + 1;
            }
            cache[j] = Math.max(cache[j - 1], currentProfit);
            j++;
        }
        System.out.println(cache[j - 1]);
        System.out.println(maxStart + " " + maxEnd);
    }
}
