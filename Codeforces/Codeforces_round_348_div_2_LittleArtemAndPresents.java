import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/2/16.
 */

public class Codeforces_round_348_div_2_LittleArtemAndPresents {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int in = input.nextInt();
        if(in % 3 == 0) {
            out.println(in / 3 * 2);
        } else if(in % 3 == 1) {
            out.println(in / 3 * 2 + 1);
        } else {
            out.println(in / 3 * 2 + 1);
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