import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/4/2017.
 */

public class Codeforces_round_163_div_2_QueueAtTheSchool {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int t = input.nextInt();
        String line = input.nextLine();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (line.charAt(j) == 'B' && line.charAt(j + 1) == 'G') {
                    line = line.substring(0, j) + "GB" + line.substring(j + 2);
                    j++;
                }
            }
        }
        out.println(line);
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

