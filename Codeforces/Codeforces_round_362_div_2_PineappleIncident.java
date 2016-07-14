import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/14/2016.
 */

public class Codeforces_round_362_div_2_PineappleIncident {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = input.nextInt();
        int s = input.nextInt();
        int x = input.nextInt();
        int remainFirst = (x - 1 - t);
        int remainSecond = (x - t);
        if((remainFirst > 0 && remainFirst % s == 0) || (remainSecond > 0 && remainSecond % s == 0) || (t == x)) {
            out.println("YES");
        } else {
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

