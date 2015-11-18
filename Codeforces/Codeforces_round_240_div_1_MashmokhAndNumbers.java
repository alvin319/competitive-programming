import java.util.Scanner;

/**
 * Created by WiNDWAY on 11/4/15.
 */
public class Codeforces_round_240_div_1_MashmokhAndNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        int answer = 0;

        if ((k < n/2) || (k != 0 && n ==1)) {
            System.out.println(-1);
        } else if (k == n/2) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i+1);
            }
        } else {
            answer = (k - n/2 + 1);
            System.out.println(answer);
            System.out.println(answer*2);
            answer *=2;
            for (int i = 1; i <= n-2; i++) {
                System.out.println(answer+i+1);
            }
        }
    }
}
