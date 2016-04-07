import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/7/16.
 */
public class Codeforces_round_166_div_2_BeautifulYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        for (int i = year + 1; i <= 9012; i++) {
            if(checkYear(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean checkYear(int year) {
        String convert = year + "";
        HashSet<Character> charSet = new HashSet<>();
        for (int i = 0; i < convert.length(); i++) {
            if(!charSet.contains(convert.charAt(i))) {
                charSet.add(convert.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }
}
