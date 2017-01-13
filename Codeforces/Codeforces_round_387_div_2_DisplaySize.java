import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alvindeng on 1/20/17.
 */
public class Codeforces_round_387_div_2_DisplaySize {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a = -1;
        int b = -1;
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (Math.abs(i - (n / i)) < diff) {
                    diff = Math.abs(i - (n / i));
                    a = Math.min(i, n / i);
                    b = Math.max(i, n / i);
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
