/**
 * Created by qicodeng on 10/27/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_289_div_2_MaximumInTable {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            m[i][0] = 1;
            m[0][i] = 1;
        }
        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                m[i][j] = m[i - 1][j] + m[i][j - 1];
                max = Math.max(max, m[i][j]);
            }
        }
        out.println(max);
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
