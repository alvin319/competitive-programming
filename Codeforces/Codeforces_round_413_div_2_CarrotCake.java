import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_413_div_2_CarrotCake {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int t = input.nextInt();
        int k = input.nextInt();
        int d = input.nextInt();
        int first = 0;
        int cookTime = 0;
        int fT = 0;
        while (n > first) {
            if (cookTime < t) {
                cookTime++;
                fT++;
            } else if (cookTime == t) {
                cookTime = 0;
                first += k;
            }
        }
        int second = 0;
        int buildTime = 0;
        cookTime = 0;
        int sT = 0;
        boolean done = false;
        while (n > second) {
            if (buildTime < d) {
                buildTime++;
            }
            if (cookTime < t) {
                cookTime++;
                sT++;
            }
            if (cookTime == t) {
                cookTime = 0;
                second += (done) ? (2 * k) : k;
            }
            if (buildTime == d) {
                done = true;
            }
        }
        out.println(fT > sT ? "YES" : "NO");
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