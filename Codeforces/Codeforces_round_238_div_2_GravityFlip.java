import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 8/28/15.
 */
public class Codeforces_round_238_div_2_GravityFlip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        for(int x : array)
            System.out.print(x+" ");
    }
}
