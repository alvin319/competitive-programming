import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/5/16.
 */
public class Balance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for(int i = 1; i <= count; i++) {
            int n = input.nextInt();
            long[] array = new long[n];
            long total = 0;
            for(int j = 0; j < array.length; j++) {
                array[j] = input.nextLong();
                total += array[j];
            }
            long throwAway = 0;
            while(total % n != 0) {
                total--;
                throwAway++;
            }
            int maxIndex = 0;
            long balance = total / n;
            int totalAmount = 0;
            int counter = 0;
            for(int j = 0; j < array.length; j++) {
                long result = Math.abs(balance - array[j]);
                if(result > 0) {
                    counter++;
                    totalAmount += result;
                }
            }
            System.out.println(throwAway + " " + (totalAmount / counter));
        }
    }
}
