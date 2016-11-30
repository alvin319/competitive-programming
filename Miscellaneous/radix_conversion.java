import java.util.Scanner;
import java.io.*;

/**
 * Created by WiNDWAY on 9/8/15.
 */
public class radix_conversion {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("Radix-Conversion_InputForSubmission_1.txt"));
        while (input.hasNext()) {
            String[] array = input.nextLine().split(",");
            String preConvert = array[0];
            int orig = Integer.parseInt(array[1]);
            int now = Integer.parseInt(array[2]);
            if (orig > 36 || orig < 2 || now > 36 || now < 2)
                System.out.println("Invalid Input");
            else {
                try {
                    System.out.println(convert(preConvert, orig, now));
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }

            }

        }
    }

    public static String convert(String now, int origBase, int newBase) {
        String converted = Integer.toString(Integer.parseInt(now, origBase), newBase);
        return converted;
    }
}
