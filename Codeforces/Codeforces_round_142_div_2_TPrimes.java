import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/25/16.
 */

public class Codeforces_round_142_div_2_TPrimes {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        boolean[] sieve = new boolean[1000000];
        sieve[0] = true;
        sieve[1] = true;
        sieve[2] = false;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = 2; j < sieve.length; j++) {
                    int sum = i * j;
                    if (sum < sieve.length) {
                        sieve[sum] = true;
                    } else {
                        break;
                    }
                }
            }
        }
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < sieve.length; i++) {
            if (!sieve[i]) {
                set.add((long)Math.pow(i, 2));
            }
        }
        for (int i = 0; i < n; i++) {
            long number = input.nextLong();
            System.out.println(set.contains(number) ? "YES" : "NO");
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