import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/7/16.
 */
public class Codeforces_round_346_div_2_NewReform {

    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static boolean[] visited;
    public static int edgeCount;
    public static int nodeCount;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int c = input.nextInt();
        int r = input.nextInt();
        for (int i = 1; i <= c; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            map.get(from).add(to);
            map.get(to).add(from);
        }
        visited = new boolean[c];
        int overall = 0;
        for(int x : map.keySet()) {
            if(!visited[x - 1]) {
                edgeCount = 0;
                nodeCount = 0;
                DFS(x);
                // 2(n - 1) = number of edges because we are double counting
                if((2 * nodeCount) == (edgeCount + 2)) {
                    overall++;
                }
            }
        }
        System.out.println(overall);
    }

    public static void DFS(int x) {
        if(visited[x - 1])
            return;
        visited[x - 1] = true;
        nodeCount++;
        edgeCount += map.get(x).size();
        for (int i = 0; i < map.get(x).size(); i++) {
            DFS(map.get(x).get(i));
        }
    }
}
