import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/4/2016.
 */

public class Codeforces_round_365_div_2_MishkaAndGame {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int rounds = input.nextInt();
        int m = 0;
        int c = 0;
        for (int i = 0; i < rounds; i++) {
            int cM = input.nextInt();
            int cC = input.nextInt();
            if (cM > cC) {
                m++;
            } else if (cC > cM) {
                c++;
            }
        }
        if (m == c) {
            out.println("Friendship is magic!^^");
        } else {
            out.println(m > c ? "Mishka" : "Chris");
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

