import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/21/2016.
 */

public class Codeforces_round_87_Party {

    static boolean[] visited;
    static HashMap<Integer, ArrayList<Integer>> map;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        map = new HashMap<>();
        int count = input.nextInt();
        visited = new boolean[count];
        for (int i = 0; i < count; i++) {
            int current = input.nextInt();
            if(current != -1) {
                current--;
                ArrayList<Integer> list;
                if(!map.containsKey(i)) {
                    list = new ArrayList<>();
                } else {
                    list = map.get(i);
                }
                list.add(current);
                map.put(i, list);
            }
        }
        int current = -1;
        for(int x : map.keySet()) {
            if(!visited[x]) {
                current = Math.max(current, DFS(x, 0));
            }
        }
        out.println(current);
        out.close();
    }

    public static int DFS(int root, int total) {
        if(!visited[root]) {
            visited[root] = true;
            int sum = 1;
            if(map.containsKey(root)) {
                for(int x : map.get(root)) {
                    sum += DFS(x, total);
                }
            }
            return sum;
        }
        return total;
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

