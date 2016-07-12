import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by alvin on 7/12/16.
 */
public class Codeforces_round_304_div_2_SoldierAndBadges {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        int cost = 0;
        for (int i = 0; i < count; i++) {
            int current = input.nextInt();
            if(!set.contains(current)) {
                set.add(current);
            } else {
                current++;
                cost++;
                while(set.contains(current)) {
                    current++;
                    cost++;
                }
                set.add(current);
            }
        }
        System.out.println(cost);
    }
}
