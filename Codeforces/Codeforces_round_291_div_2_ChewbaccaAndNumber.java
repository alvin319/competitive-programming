import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/4/2016.
 */

public class Codeforces_round_291_div_2_ChewbaccaAndNumber {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuilder current = new StringBuilder(input.nextLine());
        if(current.length() == 1 && current.charAt(0) == '9') {
            out.println(9);
        } else {
            for (int i = 0; i < current.length(); i++) {
                int now = current.charAt(i) - '0';
                int after = 9 - now;
                if (i == 0 || i == current.length() - 1) {
                    if (now != 9) {
                        out.print(Math.min(now, after));
                    } else {
                        if(i == current.length() - 1 && current.charAt(0) > 0) {
                            out.print(Math.min(now, after));
                        } else {
                            out.print(now);
                        }
                    }
                } else {
                    out.print(Math.min(now, after));
                }
            }
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

