import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/5/16.
 */
public class Mixtape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for(int i = 1; i <= count; i++) {
            long platform = input.nextLong();
            long baller = input.nextLong();
            long[] money = new long[(int)platform];
            for(int j = 0; j < money.length; j++) {
                money[j] = input.nextLong();
            }
            long total = 0;
            for(int j = 0; j < money.length; j++) {
                total += money[j] * input.nextLong();
            }
            if(baller <= total)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
