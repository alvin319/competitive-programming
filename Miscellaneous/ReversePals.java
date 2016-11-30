/**
 * Created by Alvin on 8/7/2015.
 */
import java.util.*;
import java.io.*;

public class ReversePals {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("reversepals.dat"));
        int count = input.nextInt();
        input.nextLine();
        for (int i = 0; i < count; i++) {
            String number = input.nextLine();
            System.out.println(process(number, 1));

        }
    }

    public static String process(String number, int count) {
        String totalNum = "" + (Integer.parseInt(new StringBuffer(number).reverse().toString()) + Integer.parseInt(number));
        boolean isPali = isPali(totalNum);
        return isPali ? (totalNum + " " + count) : process(totalNum, count + 1);
    }

    public static boolean isPali(String iter) {
        for (int i = 0; i < iter.length(); i++) {
            char lastChar = iter.charAt(iter.length() - 1 - i);
            if (iter.charAt(i) != lastChar)
                return false;
        }
        return true;
    }
}
