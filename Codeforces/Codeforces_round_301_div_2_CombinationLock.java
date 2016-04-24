import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/23/2016.
 */

public class Codeforces_round_301_div_2_CombinationLock {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int disk = input.nextInt();
        String original = input.nextLine();
        String open = input.nextLine();
        int solution = 0;
        for (int i = 0; i < original.length(); i++) {
            int start = (int)(original.charAt(i) - '0');
            int end = (int)(open.charAt(i) - '0');
            int zStart = 10 - Math.abs(end - start);
            int nStart = Math.abs(end - start);
            solution += Math.min(zStart, nStart);
        }
        out.println(solution);
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

