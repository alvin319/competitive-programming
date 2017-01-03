import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/4/2017.
 */

public class Codeforces_round_204_div_2_JeffAndDigits {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            if (x == 0) {
                b++;
            } else {
                a++;
            }
        }

        if (b > 0) {
            for (int i = 0; i < (a / 9) * 9; i++) {
                out.print("5");
            }
            if (a < 9) {
                b = 1;
            }
            for (int i = 0; i < b; i++) {
                out.print("0");
            }
            out.println("");
        } else {
            System.out.println("-1");
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

