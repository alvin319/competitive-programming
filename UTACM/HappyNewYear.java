import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 9/9/16.
 */

public class HappyNewYear {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        iteration:
        for (int i = 0; i < count; i++) {
            int airport = input.nextInt(), flights = input.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < airport; j++) {
                map.put(j, new ArrayList<>());
            }
            for (int j = 0; j < flights; j++) {
                int from = input.nextInt(), to = input.nextInt();
                map.get(from).add(to);
            }
            int[][] dist = new int[airport][airport];
            for (int j = 0; j < airport; j++) {
                boolean[] visited = new boolean[airport];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{j, 0});
                while (!queue.isEmpty()) {
                    int[] info = queue.poll();
                    int location = info[0];
                    int cost = info[1];
                    if (!visited[location]) {
                        visited[location] = true;
                        dist[j][location] = cost;
                        for (int neighbor : map.get(location)) {
                            queue.add(new int[]{neighbor, cost + 1});
                        }
                    }
                }
                for (int k = 0; k < airport; k++) {
                    if (!visited[k]) {
                        visited[k] = true;
                        dist[j][k] = Integer.MAX_VALUE;
                    }
                }
            }
            int answer = 0;
            for (int j = 0; j < airport; j++) {
                for (int k = 0; k < airport; k++) {
                    if (j != k) {
                        int cost = Integer.MAX_VALUE;
                        for (int l = 0; l < airport; l++) {
                            int flightCost = Math.max(dist[j][l], dist[k][l]);
                            cost = Math.min(cost, flightCost);
                        }
                        if (cost == Integer.MAX_VALUE) {
                            out.println("IMPOSSIBLE");
                            continue iteration;
                        }
                        answer = Math.max(answer, cost);
                    }
                }
            }
            out.println(answer);
        }
    }


    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}