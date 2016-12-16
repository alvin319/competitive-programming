import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/17/16.
 */

public class Codeforces_VKCup_2012_round_1_IceSculptures {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] a = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            max += a[i];
        }
        for (int j = 3; j <= n / 2; j++) {
            if (n % j == 0) {
                for (int i = 0; i < n / j; i++) {
                    int p = 0;
                    for (int k = i; k < n; k += n / j) {
                        p += a[k];
                    }
                    if (p > max) {
                        max = p;
                    }
                }
            }
        }
        System.out.println(max);
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