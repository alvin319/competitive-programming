import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class Chase {

    public static String cycle = "";
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int doors = input.nextInt();
            HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
            HashSet<Integer> unique = new HashSet<>();
            for (int j = 0; j < doors; j++) {
                int start = input.nextInt() - 1;
                int end = input.nextInt() - 1;
                unique.add(start);
                unique.add(end);
                if (!adj.containsKey(start)) {
                    ArrayList<Integer> nei = new ArrayList<>();
                    nei.add(end);
                    adj.put(start, nei);
                } else {
                    ArrayList<Integer> nei = adj.get(start);
                    nei.add(end);
                    adj.put(start, nei);
                }

            }
            isCycle(adj, unique);
            if(cycle.equals("Yes")) {
                out.println("SURVIVE");
            } else {
                out.println("DEAD");
            }
            cycle = "";

        }
        out.close();
    }

    public static boolean isCycle(HashMap<Integer, ArrayList<Integer>> adj, HashSet<Integer> set) {
        boolean visited[] = new boolean[set.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        isCyclicUtil(0, visited, -1, adj);
        return false;
    }

    public static void isCyclicUtil(int v, boolean visited[], int parent, HashMap<Integer, ArrayList<Integer>> adj) {
        visited[v] = true;
        ArrayList<Integer> list = adj.get(v);
        if(list != null) {
            for (int i = 0; i < list.size(); i++) {
                int current = list.get(i);
                if (visited[current]) {
                    cycle = "Yes";
                } else {
                    isCyclicUtil(current, visited, v, adj);
                }
            }
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