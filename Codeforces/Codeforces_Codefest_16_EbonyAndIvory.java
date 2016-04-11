import java.util.Scanner;

/**
 * Created by Alvin on 4/11/2016.
 */
public class Codeforces_Codefest_16_EbonyAndIvory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int loop = Math.max(c / a, c / b);
        boolean valid = false;
        for (int i = 0; i <= loop; i++) {
            for (int j = 0; j <= loop; j++) {
                if(i * a + j * b == c) {
                    valid = true;
                    break;
                }
            }
        }
        if(valid) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
