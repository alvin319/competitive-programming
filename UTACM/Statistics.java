import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 9/24/16.
 */

public class Statistics {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int N = input.nextInt();
            int P = input.nextInt();
            int C = input.nextInt();
            if (N > P) {
                out.println("IMPOSSIBLE");
            } else {
                boolean[] visited = new boolean[P];
                long[] groupCount = new long[P];
                HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
                for (int j = 0; j < P; j++) {
                    map.put(j, new ArrayList<>());
                }
                for (int j = 0; j < C; j++) {
                    int u = input.nextInt();
                    int v = input.nextInt();
                    map.get(u).add(v);
                    map.get(v).add(u);
                }
                ArrayDeque<Pair> queue = new ArrayDeque<>();
                int groupCounter = 0;
                for (int j = 0; j < P; j++) {
                    queue.add(new Pair(j, groupCounter++));
                }
                while (!queue.isEmpty()) {
                    Pair current = queue.poll();
                    if (!visited[current.v]) {
                        visited[current.v] = true;
                        groupCount[current.c]++;
                        for (int nei : map.get(current.v)) {
                            queue.addFirst(new Pair(nei, current.c));
                        }
                    }
                }
                Arrays.sort(groupCount);
                long currentCounter = 0;
                if (N == 0) {
                    out.println(0);
                } else {
                    for (int j = groupCount.length - 1; j >= 0; j--) {
                        N -= groupCount[j];
                        currentCounter++;
                        if (N <= 0) {
                            break;
                        }
                    }
                    out.println(currentCounter);
                }
            }
        }
        out.close();
    }

    static class Pair {
        int v;
        int c;

        public Pair(int v, int c) {
            this.v = v;
            this.c = c;
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