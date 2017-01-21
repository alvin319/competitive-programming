import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/24/2017.
 */

public class Codeforces_round_393_div_2_PetrAndACalendar {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int m = input.nextInt();
        int d = input.nextInt();
        int a = 0;
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            a = 31;
        } else if (m == 2) {
            a = 28;
        } else {
            a = 30;
        }
        int answer = 1;
        a -= (8 - d);
        while (a > 0) {
            a -= 7;
            answer++;
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

