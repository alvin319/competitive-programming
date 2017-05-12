import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/12/2017.
 */

public class Codeforces_round_412_div_2_TShirtHunt {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int p = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        for (int j = 0; j <= 500; j++) {
            for (int k = 0; k <= 500; k++) {
                int total = x - k * 50 + j * 100;
                if (total >= y && valid(total, p)) {
                    out.println(j);
                    System.exit(0);
                }
            }
        }
        out.close();
    }

    static boolean valid(int x, int p) {
        int i = (x / 50) % 475;
        for (int j = 1; j <= 25; j++) {
            i = (i * 96 + 42) % 475;
            if (i + 26 == p) {
                return true;
            }
        }
        return false;
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

