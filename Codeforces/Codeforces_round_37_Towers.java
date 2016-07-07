import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/6/2016.
 */

public class Codeforces_round_37_Towers {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int current = input.nextInt();
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        int maxHeight = -1;
        int maxHeightValue = -1;
        int total = 0;
        for (int x : map.keySet()) {
            if(map.get(x) >= maxHeight) {
                maxHeight = Math.max(map.get(x), maxHeight);
                maxHeightValue = Math.max(maxHeightValue, map.get(x));
            }
            total += 1;
        }
        out.println(maxHeight + " " + total);
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

