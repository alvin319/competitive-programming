import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/22/2016.
 */

public class Codeforces_round_339_div_2_LinkCutTree {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        BigInteger l = new BigInteger(input.nextLong() + "");
        BigInteger r = new BigInteger(input.nextLong() + "");
        BigInteger k = new BigInteger(input.nextLong() + "");
        boolean found = false;
        int level = 0;
        while (true) {
            BigInteger current = power(k, level);
            if ((current.compareTo(l) == 1 || current.compareTo(l) == 0) && (current.compareTo(r) == -1 ||
                    current.compareTo(r) == 0)) {
                System.out.print(current.toString() + " ");
                found = true;
            } else if (current.compareTo(r) == 1) {
                break;
            }
            level++;
        }
        if (!found) {
            System.out.println(-1);
        }
        out.close();
    }

    public static BigInteger power(BigInteger base, int level) {
        BigInteger total = BigInteger.ONE;
        for (int i = 0; i < level; i++) {
            total = total.multiply(base);
        }
        return total;
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

