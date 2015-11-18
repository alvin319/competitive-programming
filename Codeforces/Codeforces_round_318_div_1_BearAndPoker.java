import java.util.Scanner;

/**
 * Created by WiNDWAY on 11/4/15.
 */
public class Codeforces_round_318_div_1_BearAndPoker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] bids = new int[100001];
        int count = input.nextInt();
        for(int i = 1; i <= count; ++i) {
            int bet = input.nextInt();
            bids[i] = bet;
            while(bids[i] % 2 == 0)
                bids[i] /= 2;
            while(bids[i] % 3 == 0)
                bids[i] /= 3;

        }
        for(int i = 2; i <= count; ++i) {
            if(bids[i] != bids[1]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
