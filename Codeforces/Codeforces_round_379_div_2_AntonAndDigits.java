import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/16/16.
 */

public class Codeforces_round_379_div_2_AntonAndDigits {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int two = input.nextInt();
        int three = input.nextInt();
        int five = input.nextInt();
        int six = input.nextInt();
        int big = Math.min(two, Math.min(five, six));
        int answer = big * 256;
        two -= big;
        five -= big;
        six -= big;
        int small = Math.min(two, three);
        out.println(answer + small * 32);

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