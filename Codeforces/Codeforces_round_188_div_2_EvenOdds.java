import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/13/16.
 */

public class Codeforces_round_188_div_2_EvenOdds {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long n = input.nextLong();
        long k = input.nextLong();
        long odds = n % 2 == 1 ? n / 2 + 1 : n / 2;
        long evenStarting = odds + 1;
        if(k >= evenStarting) {
            k -= evenStarting;
            int answerEven = 2;
            out.println(answerEven * k + 2);
        } else {
            int answerOdd = 1;
            out.println(answerOdd + 2 * k - 2);
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