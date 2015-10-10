import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alvin on 10/4/2015.
 */
public class Codeforces_round_277_div_2_BerSUBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int boys[] = new int[input.nextInt()];
        for (int i = 0; i < boys.length; i++) {
            boys[i] = input.nextInt();
        }
        int girls[] = new int[input.nextInt()];
        for (int i = 0; i < girls.length; i++) {
            girls[i] = input.nextInt();
        }
        Arrays.sort(boys);
        Arrays.sort(girls);
        int pairs = 0;
        int bIndex = 0;
        int gIndex = 0;
        while(bIndex < boys.length && gIndex < girls.length) {
            int bLevel = boys[bIndex];
            int gLevel = girls[gIndex];
            if(Math.abs(bLevel - gLevel) <= 1) {
                pairs++;
                bIndex++;
                gIndex++;
            } else if(bLevel > gLevel) {
                gIndex++;
            } else {
                bIndex++;
            }
        }
        System.out.println(pairs);
    }
}
