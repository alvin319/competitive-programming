import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/9/2017.
 */

public class HackerCup_2017_ProgressPie {
    public static void main(String[] args) throws IOException {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int P = input.nextInt();
            int X = input.nextInt() - 50;
            int Y = input.nextInt() - 50;
            if (P == 0) {
                out.println("Case #" + (i + 1) + ": white");
            } else {
                boolean valid = (Math.pow(X, 2) + Math.pow(Y, 2)) < 2500;
                double theta = Math.atan2(X, Y) + 2 * Math.PI;
                double angle = (theta * 180 / Math.PI) % 360;
                out.println("Case #" + (i + 1) + ": " + ((angle < (P / 100.0 * 360)) && valid ? "black" : "white"));
            }
        }
        out.close();
    }

    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() throws IOException {
            br = new BufferedReader(new FileReader("progresspie.in"));
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

