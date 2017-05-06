import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_412_div_2_IsItRated {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        boolean equal = true;
        boolean sorted = true;
        int previousSecond = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int first = input.nextInt();
            int second = input.nextInt();
            if (first != second) {
                equal = false;
            }
            if (second > previousSecond) {
                sorted = false;
            }
            previousSecond = second;
        }
        if (!equal) {
            out.println("rated");
        } else if (!sorted) {
            out.println("unrated");
        } else {
            out.println("maybe");
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