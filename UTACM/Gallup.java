import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/23/16.
 */

public class Gallup {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int Q = input.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int calls = Integer.MIN_VALUE;
            for (int j = 0; j < Q; j++) {
                int N = input.nextInt();
                int M = input.nextInt();
                if (!map.containsKey(N)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(M);
                    map.put(N, list);
                } else {
                    map.get(N).add(M);
                }
                calls = Math.max(calls, N * M);
            }
            long answer = 0;
            for (int N : map.keySet()) {
                for (int j = 0; j < map.get(N).size(); j++) {
                    answer += calls / N;
                }
            }
            out.println(answer);
        }
        out.close();
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