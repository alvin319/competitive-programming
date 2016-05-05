import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/5/16.
 */

public class Codeforces_round_350_div_2_Holidays {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int days = input.nextInt();
        int week = days / 7;
        int remain = days % 7;
        int maximum = week * 2;
        int minimum = week * 2;

        switch(remain) {
            case 1 : {
                maximum++;
            } break;
            case 2 : {
                maximum += 2;
            } break;
            case 3 : {
                maximum += 2;
            } break;
            case 4 : {
                maximum += 2;
            } break;
            case 5 : {
                maximum += 2;
            } break;
            case 6 : {
                maximum += 2;
                minimum += 1;
            } break;
            default : {
            } break;
        }
        out.println(minimum + " " + maximum);
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