import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/4/15.
 */
public class Codeforces_round_286_div_2_MrKitayutasGift {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String original = input.nextLine();
        boolean isPalin = false;
        startingLoop:
        for(int i=0; i<=25; i++) {
            for(int j=0; j<=original.length(); j++) {
                String checking = original.substring(0, j) + (char)(i + 97) + original.substring(j, original.length());
                isPalin = checkPalindrome(checking);
                if(isPalin) {
                    System.out.println(checking);
                    break startingLoop;
                }
            }
        }
        if(!isPalin)
            System.out.println("NA");
    }

    public static boolean checkPalindrome(String check) {
        return new StringBuilder(check).reverse().toString().equals(check);
    }
}
