import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/24/2016.
 */

public class Codeforces_round_335_div_2_MagicSpheres {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        int remainBalls = 0;
        if(a - x > 0) {
            remainBalls += (a - x) / 2;
        }

        if(b - y > 0) {
            remainBalls += (b - y) / 2;
        }
        if(c - z > 0) {
            remainBalls += (c - z) / 2;
        }
        if(a < x) {
            remainBalls -= (x - a);
        }
        if(b < y) {
            remainBalls -= (y - b);
        }
        if(c < z) {
            remainBalls -= (z - c);
        }
        if(remainBalls >= 0) {
            out.println("Yes");
        } else {
            out.println("No");
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

