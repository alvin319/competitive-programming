import java.util.Scanner;

/**
 * Created by WiNDWAY on 6/9/2017.
 */
public class Codeforces_round_416_div_2_VladiskAndCourtesy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int give = 1;
        while (a >= 0 && b >= 0) {
            if (give % 2 == 1) {
                if (a < give) {
                    System.out.println("Vladik");
                    System.exit(0);
                }
                a -= give;
            } else {
                if (b < give) {
                    System.out.println("Valera");
                    System.exit(0);
                }
                b -= give;
            }
            give++;
        }
    }
}
