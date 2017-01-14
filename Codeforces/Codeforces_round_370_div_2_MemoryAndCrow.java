import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alvindeng on 1/20/17.
 */
public class Codeforces_round_370_div_2_MemoryAndCrow {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int[] answer = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) {
                answer[i] = array[i];
            } else {
                answer[i] = array[i] + array[i + 1];
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(i == 0 ? answer[i] : " " + answer[i]);
        }
    }
}
