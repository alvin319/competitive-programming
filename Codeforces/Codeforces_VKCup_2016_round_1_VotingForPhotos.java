import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Alvin on 4/7/2016.
 */
public class Codeforces_VKCup_2016_round_1_VotingForPhotos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;
        int winner = 0;
        for (int i = 0; i < count; i++) {
            int current = input.nextInt();
            if(!map.containsKey(current)) {
                map.put(current, 1);
                if(map.get(current) > maxValue) {
                    maxValue = 1;
                    winner = current;
                }
            } else {
                map.put(current, map.get(current) + 1);
                if(map.get(current) > maxValue) {
                    maxValue = map.get(current);
                    winner = current;
                }
            }
        }
        System.out.println(winner);
    }
}
