import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/8/16.
 */
public class Codeforces_VolBIT_LuckyNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        System.out.println((long)Math.pow(2, count+1) - 2);
    }
}
