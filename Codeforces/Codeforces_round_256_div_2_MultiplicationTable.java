import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/30/15.
 */
public class Codeforces_round_256_div_2_MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        long m = input.nextLong();
        long k = input.nextLong();
        long start = 1;
        long end = n * m + 1;
        while(start < end) {
            long mid = (start + end) / 2;
            if(findBiggest(mid, n, m) < k)
                start = mid + 1;
            else
                end = mid;
        }
        System.out.println(start);
    }

    public static long findBiggest(long mid, long n, long m) {
        long result = 0;
        for(int i = 1; i <= n; i++) {
            result += Math.min(m, mid / i);
        }
        return result;
    }
}
