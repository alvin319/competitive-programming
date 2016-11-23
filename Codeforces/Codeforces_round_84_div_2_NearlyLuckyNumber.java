import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/25/16.
 */

public class Codeforces_round_84_div_2_NearlyLuckyNumber {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int f = 0;
        int s = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '4') {
                f++;
            }
            if (line.charAt(i) == '7') {
                s++;
            }
        }
        out.println(f + s == 4 || f + s == 7 ? "YES" : "NO");
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