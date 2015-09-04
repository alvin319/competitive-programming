import java.util.*;

/**
 * Created by WiNDWAY on 9/4/15.
 */

public class Codeforces_round_295_div_2_TwoButtons {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Queue<int[]> eventList = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int[] init = {n, 0};
        eventList.add(init);
        boolean escape = false;
        while(!eventList.isEmpty() && !escape) {
            int[] check = eventList.poll();
            if (!visited.contains(check[0])) {
                visited.add(check[0]);
                if (check[0] == m) {
                    System.out.println(check[1]);
                    escape = true;
                    continue;
                }
                int[] first = {check[0] - 1, check[1] + 1};
                int[] second = {check[0] * 2, check[1] + 1};
                if(first[0] >= 1)
                    eventList.add(first);
                if (second[0] >= 1 && second[0] <= (m*2))
                    eventList.add(second);
            }
        }
    }
}