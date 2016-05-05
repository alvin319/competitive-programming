import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/5/16.
 */

public class Codeforces_round_350_div_2_GameofRobots {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long k = input.nextLong();
        long[] array = new long[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextLong();
        }
        for (long i = 0; i < n; i++) {
            long start = i * (i + 1) / 2 + 1;
            long end = (i + 1) * (i + 2) / 2;
            if(k >= start && k <= end) {
                out.println(array[(int)(k - start)]);
                System.exit(0);
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