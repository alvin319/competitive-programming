import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Alvin on 4/11/2016.
 */
public class Codeforces_VKCup_2016_round_1_RunningWithObstacles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int s = input.nextInt();
        int d = input.nextInt();
        int[] obstacles = new int[n];
        for (int i = 0; i < n; i++) {
            obstacles[i] = input.nextInt();
        }
        Arrays.sort(obstacles);
    }
}
