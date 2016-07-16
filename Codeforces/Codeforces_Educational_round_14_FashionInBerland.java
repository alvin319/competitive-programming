import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/18/2016.
 */

public class Codeforces_Educational_round_14_FashionInBerland {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        if (count == 1) {
            int next = input.nextInt();
            out.println(next == 1 ? "YES" : "NO");
        } else {
            int countZero = 0;
            for (int i = 0; i < count; i++) {
                int current = input.nextInt();
                if (current == 0) {
                    countZero++;
                }
            }
            out.println(countZero == 1 ? "YES" : "NO");
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

