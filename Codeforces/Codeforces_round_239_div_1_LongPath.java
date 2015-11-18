import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/21/15.
 */
public class Codeforces_round_239_div_1_LongPath {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rooms = input.nextInt();
        long mod = (long) 1e9 + 7;
        long[] recurrence = new long[rooms + 1];
        for(int i = 1; i <= rooms; i++) {
            recurrence[i] = ((mod + recurrence[i-1] + recurrence[i-1] - recurrence[(int)(input.nextLong() - 1)] + 2) % mod) % mod;
        }
        System.out.println(recurrence[rooms]);
    }
}