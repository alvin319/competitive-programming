import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/10/2017.
 */

public class Codeforces_GoodBye_2015_NewYearAndDays {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String[] info = input.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        out.print(info[2].equals("week") ? (n < 5 || n > 6 ? 52 : 53) : (n < 30 ? 12 : n == 30 ? 11 : 7));
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

