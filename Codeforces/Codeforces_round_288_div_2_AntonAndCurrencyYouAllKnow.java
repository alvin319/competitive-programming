import java.util.Scanner;

/**
 * Created by alvin on 8/19/16.
 */
public class Codeforces_round_288_div_2_AntonAndCurrencyYouAllKnow {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder array = new StringBuilder(input.nextLine());
        int firstIndex = -1;
        int lastIndex = -1;
        for (int i = 0; i < array.length(); i++) {
            int currentDight = array.charAt(i) - '0';
            if (currentDight % 2 == 0 && array.charAt(i) < array.charAt(array.length() - 1)) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex != -1) {
            char temp = array.charAt(array.length() - 1);
            array.setCharAt(array.length() - 1, array.charAt(firstIndex));
            array.setCharAt(firstIndex, temp);
            System.out.println(array);
        } else {
            for (int i = array.length() - 1; i >= 0; i--) {
                int currentDight = array.charAt(i) - '0';
                if (currentDight % 2 == 0 && array.charAt(i) > array.charAt(array.length() - 1)) {
                    lastIndex = i;
                    break;
                }
            }

            if (lastIndex != -1) {
                char temp = array.charAt(array.length() - 1);
                array.setCharAt(array.length() - 1, array.charAt(lastIndex));
                array.setCharAt(lastIndex, temp);
                System.out.println(array);
            } else {
                System.out.println(-1);
            }
        }
    }

}
