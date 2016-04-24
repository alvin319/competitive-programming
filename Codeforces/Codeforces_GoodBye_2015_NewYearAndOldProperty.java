import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/23/2016.
 */

public class Codeforces_GoodBye_2015_NewYearAndOldProperty {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long a = input.nextLong();
        long b = input.nextLong();
        long answer = 0;
        for (int i = 1; i < 62; i++) {
            long n = (1L << i) - 1;
            for (int j = 0; j < i - 1; j++) {
                long t = n ^ (1L << j);
                if (t >= a && t <= b) {
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

