import java.util.Scanner;

/**
 * Created by alvin on 8/14/16.
 */
public class Codeforces_round_Educational_round_13_JohnyLikesNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int start = n / k;
        for (int i = start * k; true ; i += k) {
            if (i > n) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}
