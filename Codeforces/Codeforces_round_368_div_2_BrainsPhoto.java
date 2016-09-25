/**
 * Created by qicodeng on 9/27/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_368_div_2_BrainsPhoto {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[][] m = new char[input.nextInt()][input.nextInt()];
        boolean isColor = false;
        for (int i = 0; i < m.length; i++) {
            m[i] = input.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 'C' || m[i][j] == 'M' || m[i][j] == 'Y') {
                    isColor = true;
                    break;
                }
            }
        }
        out.println(isColor ? "#Color" : "#Black&White");
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
