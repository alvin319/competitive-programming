import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/24/16.
 */

public class Codeforces_round_216_div_2_ValeraAndPlates {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        int[] info = new int[n];
        for (int i = 0; i < info.length; i++) {
            info[i] = input.nextInt();
        }
        int answer = 0;
        for (int i = 0; i < info.length; i++) {
            int current = info[i];
            if (current == 1) {
                if (m > 0) {
                    m--;
                } else {
                    answer++;
                }
            } else {
                if (k > 0) {
                    k--;
                } else if (m > 0) {
                    m--;
                } else {
                    answer++;
                }
            }
        }
        out.println(answer);
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