import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alvin on 7/9/16.
 */

public class Codeforces_round_356_div_2_BearAndFiveCards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int current = input.nextInt();
            total += current;
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        int minCards = total;
        for (int x : map.keySet()) {
            if (map.get(x) == 2) {
                minCards = Math.min(minCards, total - (x * 2));
            } else if (map.get(x) > 2) {
                minCards = Math.min(minCards, total - (x * 3));
            }
        }
        System.out.println(minCards);

    }
}
