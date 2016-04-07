import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/5/16.
 */

public class StockMaximize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            long[] stock = new long[input.nextInt()];
            for (int j = 0; j < stock.length; j++) {
                stock[j] = input.nextLong();
            }
            long totalProfit = 0;
            for (int j = 0; j < stock.length; j++) {
                long maxProfit = 0;
                for (int k = j; k < stock.length; k++) {
                    long currentProfit = stock[k] - stock[j];
                    maxProfit = Math.max(currentProfit, maxProfit);
                }
                totalProfit += maxProfit;
            }
            System.out.println(totalProfit);
        }
    }
}
