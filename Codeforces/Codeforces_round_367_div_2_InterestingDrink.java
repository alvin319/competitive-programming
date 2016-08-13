import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by alvin on 8/13/16.
 */
public class Codeforces_round_367_div_2_InterestingDrink {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (!map.containsKey(current)) {
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(current, indexList);
            } else {
                ArrayList<Integer> indexList = map.get(current);
                indexList.add(i);
                map.put(current, indexList);
            }
        }
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int coins = input.nextInt();
            if (map.floorKey(coins) != null) {
                int key = map.floorKey(coins);
                ArrayList<Integer> index = map.get(key);
                int biggest = index.get(index.size() - 1);
                System.out.println(biggest + 1);
            } else {
                System.out.println("0");
            }
        }
    }
}
