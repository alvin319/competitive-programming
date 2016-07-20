import java.util.Scanner;

/**
 * Created by alvin on 7/21/16.
 */
public class Codeforces_round_40_div_2_Translation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder buffer = new StringBuilder(input.nextLine());
        System.out.println(buffer.reverse().toString().equals(input.nextLine()) ? "YES" : "NO");
    }
}
