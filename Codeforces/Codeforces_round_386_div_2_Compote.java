import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/19/16.
 */

public class Codeforces_round_386_div_2_Compote {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int set = 0;
        while (a > 0 && b > 0 && c > 0) {
            a--;
            b -= 2;
            c -= 4;
            set += 1;
        }
        if (a < 0 || b < 0 || c < 0) {
            set--;
        }
        out.println(set * 7);
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