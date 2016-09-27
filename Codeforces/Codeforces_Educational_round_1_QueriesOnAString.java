/**
 * Created by qicodeng on 9/27/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Codeforces_Educational_round_1_QueriesOnAString {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int q = input.nextInt();
        for (int i = 0; i < q; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            int k = input.nextInt();
            k %= (r - l + 1);
            l--;
            line = line.substring(0, l) + line.substring(r - k, r) + line.substring(l, r - k) + line.substring(r, line.length());
        }
        out.println(line);
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
