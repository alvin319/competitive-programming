/**
 * Created by qicodeng on 11/28/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_382_div_2_OstapAndGrasshopper {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        char[] array = input.nextLine().toCharArray();
        int gIndex = -1;
        int tIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'G') {
                gIndex = i;
            }
            if (array[i] == 'T') {
                tIndex = i;
            }
        }
        if (gIndex < tIndex) {
            while (gIndex < array.length && array[gIndex] != '#') {
                if (gIndex == tIndex) {
                    out.println("YES");
                    System.exit(0);
                } else {
                    gIndex += k;
                }
            }
            out.println("NO");
        } else {
            while (gIndex >= 0 && array[gIndex] != '#') {
                if (gIndex == tIndex) {
                    out.println("YES");
                    System.exit(0);
                } else {
                    gIndex -= k;
                }
            }
            out.println("NO");
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
