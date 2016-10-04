/**
 * Created by qicodeng on 10/4/16.
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_Educational_round_13_JotyAndChocolate {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long n = input.nextLong();
        long a = input.nextLong();
        long b = input.nextLong();
        long p = input.nextLong();
        long q = input.nextLong();
        out.println(p * (n / a) + q * (n / b) - Math.min(p, q) * (n / (a / gcd(a, b) * b)));
        out.close();
    }

    public static long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
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
