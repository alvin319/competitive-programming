import java.util.Scanner;

/**
 * Created by alvindeng on 4/14/17.
 */
public class Codeforces_round_107_div_2_SoftDrinking {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int l = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        int p = input.nextInt();
        int nl = input.nextInt();
        int np = input.nextInt();

        int bottles = (k * l) / (nl * n);
        int lime = (c * d) / n;
        int salt = p / (np * n);
        System.out.println(Math.min(bottles, Math.min(lime, salt)));
    }
}
