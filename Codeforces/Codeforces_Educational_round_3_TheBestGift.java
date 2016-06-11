import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 6/11/16.
 */

public class Codeforces_Educational_round_3_TheBestGift {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long[] array = new long[input.nextInt()];
        for (int i = 0; i < n; i++) {
            array[input.nextInt() - 1]++;
        }
        BigInteger total = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n - 1)).divide(BigInteger.valueOf(2));
        for (int i = 0; i < array.length; i++) {
            total = total.subtract(BigInteger.valueOf(array[i]).multiply(BigInteger.valueOf(array[i] - 1)).divide(BigInteger.valueOf(2)));
        }
        out.println(total);
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