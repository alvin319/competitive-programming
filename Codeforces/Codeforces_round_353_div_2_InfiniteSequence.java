import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/17/2016.
 */

public class Codeforces_round_353_div_2_InfiniteSequence {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        if (c == 0 && a != b) {
            out.println("NO");
        } else if (a == b) {
            out.println("YES");
        } else {
            long result = a >= 0 && b < 0 && c < 0 ? (b - a) % c : (Math.abs(b) - Math.abs(a)) % c;
            if(a < 0 && b >= 0 && c > 0) {
                result = (Math.abs(a) + b) % c;
            }
            if(a < 0 && b < 0 && c < 0) {
                result = (Math.abs(a) + Math.abs(b)) % Math.abs(c);
            }
            if((a < 0 && b >= 0 && c < 0) || (a >= 0 && b < 0 && c >= 0) || (a < 0 && b < 0 && c < 0 && (b > a))
                    || (a < 0 && b < 0 && c > 0 && a >= b) || (a >= 0 && b >= 0 && c < 0 && b >= a) || (b <= a && c > 0)) {
                out.println("NO");
            } else {
                out.println(result == 0 ? "YES" : "NO");
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

