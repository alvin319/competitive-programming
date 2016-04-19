import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WiNDWAY on 4/18/16.
 */

public class Codeforces_round_324_div_2_DimaAndLisa {

    public static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        if(isPrime(n)) {
            out.println(1);
            out.println(n);
            System.exit(0);
        }
        sieve(n / 2);
        System.out.println("last: " + set.last());
        for(int x : set) {
            for(int y : set) {
                if((x + y) == n) {
                    out.println(2);
                    out.println(x + " " + y);
                    System.exit(0);
                }
                int remain = n - x - y;
                if(remain == x || remain == y) {
                    out.println(3);
                    out.println(remain + " " + x + " " + y);
                    System.exit(0);
                }
                if(set.contains(remain)) {
                    out.println(3);
                    out.println(remain + " " + x + " " + y);
                    System.exit(0);
                }

            }
        }
        out.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void sieve(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                set.add(p);
            }
        }
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