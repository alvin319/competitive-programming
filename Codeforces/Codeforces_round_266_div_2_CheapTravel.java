import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/13/16.
 */

public class Codeforces_round_266_div_2_CheapTravel {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int count = n / m;
        int total = n % m != 0 ? count + 1 : count;
        out.println(Math.min(n * a, Math.min(total * b, Math.min(count * b + (n % m * a), total * b))));
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