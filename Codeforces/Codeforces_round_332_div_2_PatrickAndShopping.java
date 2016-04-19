import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/19/2016.
 */

public class Codeforces_round_332_div_2_PatrickAndShopping {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long first = input.nextLong();
        long second = input.nextLong();
        long third = input.nextLong();
        long p1 = first + third + second;
        long p2 = first + first + second + second;
        long p3 = second + third + third + second;
        long p4 = 2 * first + third * 2;
        out.println(Math.min(p1, Math.min(p2, Math.min(p3, p4))));

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

