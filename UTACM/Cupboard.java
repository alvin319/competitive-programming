import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Cupboard {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            long h = input.nextLong();
            long d = input.nextLong();
            long w = input.nextLong() * 12;
            long n = input.nextLong();
            long box = 1;
            box *= h;
            box *= d;
            box *= w;
            long answer = 1;
            if (n > 1) {
                answer *= ((n+1) * (n) / 2) * box;
            } else if (n == 1) {
                answer *= box;
            } else {
                answer = 0;
            }
            out.println(answer);
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