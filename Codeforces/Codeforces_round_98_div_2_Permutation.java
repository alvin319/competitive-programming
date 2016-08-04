import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alvin on 8/1/16.
 */
public class Codeforces_round_98_div_2_Permutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] array = new int[count];
        Arrays.fill(array, -1);
        for (int i = 0; i < count; i++) {
            int current = input.nextInt();
            if (current - 1 < array.length && current - 1 >= 0) {
                array[current - 1] = current;
            }
        }
        int answer = 0;
        for (int i = 0; i < count; i++) {
            if (array[i] == -1) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
