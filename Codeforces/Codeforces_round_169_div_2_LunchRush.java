import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 10/29/16.
 */

public class Codeforces_round_169_div_2_LunchRush {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int f = input.nextInt();
            int t = input.nextInt();
            if (k >= t) {
                best = Math.max(best, f);
            } else {
                best = Math.max(best, f - (t - k));
            }
        }
        out.println(best);
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