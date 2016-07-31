/**
 * Created by WiNDWAY on 3/18/16.
 */
public class minCoin {
    public static void main(String[] args) {
        int v = 27;
        int[] denominations = {2, 4, 7, 11, 15};
        int[] values = new int[v + 1];
        final int DEFAULT = Integer.MAX_VALUE / 2;
        for (int i = 0; i < denominations.length; i++) {
            values[denominations[i]] = 1;
        }
        for (int i = 0; i < values.length; i++) {
            int minimumValue = DEFAULT;
            for (int j = 0; j < denominations.length; j++) {
                int remainingValue = i - denominations[j];
                if (remainingValue >= 0 && values[remainingValue] != 0) {
                    minimumValue = Math.min(minimumValue, 1 + values[remainingValue]);
                }
            }
            values[i] = minimumValue == DEFAULT ? values[i] : minimumValue;
        }

        System.out.println(values[v]);
        for (int x : values) {
            System.out.print(x + " ");
        }
    }
}
