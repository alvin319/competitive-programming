import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/31/16.
 */

public class Codeforces_round_105_div_2_InsomniaCure {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int k = input.nextInt();
        int l = input.nextInt();
        int m = input.nextInt();
        int n = input.nextInt();
        int d = input.nextInt();
        int kCounter = 1;
        int lCounter = 1;
        int mCounter = 1;
        int nCounter = 1;
        long total = 0;
        for(int i = 1; i <= d; i++) {
            if(kCounter == k || lCounter == l || mCounter == m || nCounter == n) {
                total++;
            }
            kCounter = kCounter >= k ? 1 : kCounter + 1;
            lCounter = lCounter >= l ? 1 : lCounter + 1;
            mCounter = mCounter >= m ? 1 : mCounter + 1;
            nCounter = nCounter >= n ? 1 : nCounter + 1;
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
