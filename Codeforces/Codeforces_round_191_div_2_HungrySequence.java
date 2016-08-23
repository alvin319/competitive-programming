import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/23/16.
 */

public class Codeforces_round_191_div_2_HungrySequence {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        boolean[] sieve = new boolean[10000000];
        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = 2; j <= sieve.length; j++) {
                    int sum = i * j;
                    if (sum < sieve.length) {
                        sieve[sum] = true;
                    } else {
                        break;
                    }
                }
            }
        }
        int count = input.nextInt();
        int currentCounter = 1;
        out.print(2);
        for (int i = 3; i < sieve.length; i++) {
            if (!sieve[i] && currentCounter < count) {
                out.print(" " + i);
                currentCounter++;
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