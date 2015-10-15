import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/14/15.
 */

/* bigInteger didn't work for me :'( */

public class Codeforces_round_113_div_2_Tetrahedron {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int iteration = input.nextInt();
        long modulus = 1000000007;
        long currentTop = 0;
        long currentWays = 0;
        long finalWays = 1;
        long currentR = 0;

        for (int i = 1; i <= iteration; i++) {
            currentTop = currentR * 3 % modulus;
            currentWays = (currentR * 2 + finalWays) % modulus;
            finalWays = currentTop;
            currentR = currentWays;
        }

        System.out.println(finalWays);

    }
}
