import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/24/2017.
 */

public class Codeforces_round_189_div_2_MagicNumbers {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
            if (i + 3 <= line.length() && line.substring(i, i + 3).equals("144")) {
                i = i + 2;
            } else if (i + 2 <= line.length() && line.substring(i, i + 2).equals("14")) {
                i = i + 1;
            } else if (line.charAt(i) == '1') {
                i = i;
            } else {
                out.println("NO");
                System.exit(0);
            }
        }
        out.println("YES");
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

