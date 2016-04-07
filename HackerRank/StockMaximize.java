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
            long last = stock[stock.length - 1];

            for(int j = stock.length - 1; j >= 0; j--){
                if(stock[j] > last) {
                    last = stock[j];
                }
                totalProfit += last - stock[j];
            }

            System.out.println(totalProfit);
        }
    }
}
