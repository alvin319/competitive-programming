import java.io.*;
import java.util.StringTokenizer;


public class Codeforces_round_433_div_2_Fraction {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int bestA = 0;
        int bestB = 0;
        double bestValue = Double.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            int j = n - i;
            if (i < j) {
                int result = gcd(i, j);
                if (result == 1 && ((double)i) / j > bestValue) {
                    bestValue = ((double) i) / j;
                    bestA = i;
                    bestB = j;
                }
            }
        }
        out.println(bestA + " " + bestB);
        out.close();
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
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