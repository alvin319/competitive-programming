import java.util.*;

/**
 * Created by Alvin on 4/7/2016.
 */
public class Codeforces_VKCup_2016_round_1_ChatOrder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        input.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < count; i++) {
            String current = input.nextLine();
            if(!map.containsKey(current)) {
                map.put(current, index++);
            } else {
                map.remove(current);
                map.put(current, index++);
            }
        }
        TreeSet<String> keys = new TreeSet<String>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return -1 * map.get(o1).compareTo(map.get(o2));
            }
        });
        keys.addAll(map.keySet());
        for(String x : keys) {
            System.out.println(x);
        }
    }
}