import java.util.*;
import java.io.*;

/**
 * Created by alvindeng on 1/19/17.
 */

public class Codeforces_round_392_div_2_HolidayOfEquality {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int[] array = new int[input.nextInt()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += Math.abs(array[i] - max);
        }
        System.out.println(answer);
    }
}
