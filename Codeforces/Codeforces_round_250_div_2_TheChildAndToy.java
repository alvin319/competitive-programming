import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Alvin on 5/28/2016.
 */

public class Codeforces_round_250_div_2_TheChildAndToy {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = input.nextInt();
        }
        BigInteger total = BigInteger.ZERO;
        for (int i = 0; i < m; i++) {
            int start = input.nextInt() - 1;
            int end = input.nextInt() - 1;
            int weight = Math.min(cost[start], cost[end]);
            total = total.add(BigInteger.valueOf(weight));
        }
        out.println(total);
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

