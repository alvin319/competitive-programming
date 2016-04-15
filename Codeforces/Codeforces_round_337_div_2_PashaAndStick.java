import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/14/2016.
 */
public class Codeforces_round_337_div_2_PashaAndStick {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long current = input.nextLong();
        double potentialZero = (double)current / 4 - Math.floor((double)current / 4);
        if(potentialZero == 0.25 || potentialZero == 0.75) {
            out.println(0);
        } else if(current % 4 != 0) {
            out.println(current / 4);
        } else {
            out.println((current / 4) - 1);
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
