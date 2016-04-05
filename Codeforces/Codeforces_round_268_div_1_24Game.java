import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/5/16.
 */
public class Codeforces_round_268_div_1_24Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n <= 3) {
            System.out.println("NO");
        } else if (n % 2 == 0) {
            System.out.println("YES");
            System.out.println("1 * 2 = 2");
            System.out.println("2 * 3 = 6");
            System.out.println("6 * 4 = 24");
            for (int i = 5; i < n; i+= 2) {
                System.out.println(i+1 + " - " + i + " = 1");
                System.out.println("24 * 1 = 24");
            }
        } else {
            System.out.println("YES");
            System.out.println("2 - 1 = 1");
            System.out.println("1 + 3 = 4");
            System.out.println("4 * 5 = 20");
            System.out.println("20 + 4 = 24");
            for (int i = 6; i < n; i+= 2) {
                System.out.println(i+1 + "  - " + i + " = 1");
                System.out.println("24 * 1 = 24");
            }
        }
    }
}
