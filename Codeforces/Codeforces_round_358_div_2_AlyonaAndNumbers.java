import java.util.Scanner;

/**
 * Created by alvin on 8/14/16.
 */
public class Codeforces_round_358_div_2_AlyonaAndNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] a = remain(n);
        int[] b = remain(m);
        long answer = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if ((a[i] + b[j]) % 5 == 0) {
                    answer += (long)a[i] * (long)b[i];
                }
            }
        }
        System.out.println(answer);
    }

    public static int[] remain(int n) {
        int[] r = new int[5];
        for (int i = 1; i <= n; i++) {
            r[i % 5]++;
        }
        return r;
    }
}
