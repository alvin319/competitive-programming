import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by alvindeng on 2/23/17.
 */
public class Codeforces_round_399_div_2_OathOfTheNightsWatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            s.add(array[i]);
        }
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (s.floor(value - 1) != null && s.ceiling(value + 1) != null) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
