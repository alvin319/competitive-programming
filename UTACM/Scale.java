import java.math.BigInteger;
import java.util.*;

/**
 * Created by WiNDWAY on 2/19/16.
 */
public class Scale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            long[] souls = new long[input.nextInt()];
            for (int j = 0; j < souls.length; j++) {
                souls[j] = input.nextLong();
            }
            Arrays.sort(souls);
            BigInteger total = BigInteger.ZERO;
            long answer = 0;
            for (int j = 0; j < souls.length; j++) {
                if(total.compareTo(new BigInteger(""+souls[j])) == 0 || total.compareTo(new BigInteger(""+souls[j])) < 0) {
                    answer++;
                    total = total.add(new BigInteger(souls[j] + ""));
                } else {
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
