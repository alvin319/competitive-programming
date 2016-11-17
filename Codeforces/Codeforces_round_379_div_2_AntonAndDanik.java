import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/16/16.
 */

public class Codeforces_round_379_div_2_AntonAndDanik {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String l = input.nextLine();
        int a = 0;
        int d = 0;
        for (int i = 0; i < l.length(); i++) {
            if (l.charAt(i) == 'A') {
                a++;
            } else {
                d++;
            }
        }
        out.println(a == d ? "Friendship" : a > d ? "Anton" : "Danik");
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