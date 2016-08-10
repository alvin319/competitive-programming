import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alvin on 8/10/16.
 */
public class Codeforces_round_364_div_2_CellsNotUnderAttack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        int m = input.nextInt();
        BigInteger total = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n));
        HashSet<Integer> xSet = new HashSet<>();
        HashSet<Integer> ySet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            xSet.add(input.nextInt());
            ySet.add(input.nextInt());
            System.out.println(total.subtract(BigInteger.valueOf((long)xSet.size()).multiply(BigInteger.valueOf(n)).
                    add(BigInteger.valueOf((long)ySet.size()).multiply(BigInteger.valueOf(n))).subtract(BigInteger.
                    valueOf((long)ySet.size()).multiply(BigInteger.valueOf((long)xSet.size())))));
        }
    }
}
