import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/21/2016.
 */

public class Codeforces_Educational_round_7_InfiniteSequence {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long position = input.nextLong();
        for (long i = 0; i < position; i++) {
            long start = i * (i + 1) / 2 + 1;
            long end = (i + 1) * (i + 2) / 2;
            if(position >= start && position <= end) {
                out.println(position - start + 1);
                System.exit(0);
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

