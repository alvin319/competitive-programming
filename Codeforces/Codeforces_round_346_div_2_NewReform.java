import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/7/16.
 */
public class Codeforces_round_346_div_2_NewReform {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        int r = input.nextInt();
        HashSet<Integer> cities = new HashSet<>();
        for (int i = 0; i < r; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            if(!cities.contains(from)) {
                cities.add(from);
            } else if(!cities.contains(to)) {
                cities.add(to);
            }
        }
        System.out.println(c - cities.size());
    }
}
