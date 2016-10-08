/**
 * Created by qicodeng on 10/10/16.
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_round_101_div_2_AmusingJoke {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String f = input.nextLine();
        String s = input.nextLine();
        String l = input.nextLine();
        HashMap<Character, Integer> m = new HashMap<>();
        for (char x : f.toCharArray()) {
            m.put(x, m.containsKey(x) ? m.get(x) + 1 : 1);
        }
        for (char x : s.toCharArray()) {
            m.put(x, m.containsKey(x) ? m.get(x) + 1 : 1);
        }
        for (char x : l.toCharArray()) {
            if (!m.containsKey(x)) {
                out.println("NO");
                System.exit(0);
            } else {
                int c = m.get(x);
                if (c == 1) {
                    m.remove(x);
                } else {
                    m.put(x, c - 1);
                }
            }
        }
        out.println(m.keySet().isEmpty() ? "YES" : "NO");
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
