import java.util.Scanner;

/**
 * Created by alvindeng on 5/18/17.
 */
public class Codeforces_Educational_round_21_LuckyYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int current = Integer.parseInt(line);
        char first = line.charAt(0);
        if (first >= '1' && first <= '8') {
            int result = (int)(((first - '0') + 1) * Math.pow(10, line.length() - 1));
            System.out.println(result - current);
        } else {
            System.out.println((int)Math.pow(10, line.length()) - current);
        }
    }
}
