import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Alvin on 8/12/15.
 */

public class Codeforces_round_315_div_2_Music {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int loopCount = 0;
        int total = input.nextInt();
        int existTime = input.nextInt();
        int downloadTime = input.nextInt();
        while(existTime < total) {
            existTime *= downloadTime;
            loopCount++;

        }
        System.out.println(loopCount);
    }
}
