/**
 * Created by qicodeng on 12/14/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_384_div_2_VladikAndFlights {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int airport = input.nextInt();
        int a = input.nextInt() - 1;
        int b = input.nextInt() - 1;
        String line = input.nextLine();
        int[] info = new int[line.length()];
        for (int i = 0; i < info.length; i++) {
            info[i] = line.charAt(i) - '0';
        }
        if (info[a] == info[b]) {
            out.println(0);
        } else {
            out.println(1);
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
