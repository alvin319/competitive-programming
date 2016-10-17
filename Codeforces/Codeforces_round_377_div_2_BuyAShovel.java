/**
 * Created by qicodeng on 10/17/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_377_div_2_BuyAShovel {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int k = input.nextInt();
        int r = input.nextInt();
        for (int i = 1; i <= 1000000; i++) {
            long totalPrice = i * k;
            if (totalPrice % 10 == r || totalPrice % 10 == 0) {
                out.println(i);
                System.exit(0);
            }
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
