import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/17/16.
 */

public class Codeforces_round_161_div_2_BeautifulMatrix {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int i, j, x = 0, y = 0;
        int result = 0;
        int[][] matrix = new int[5][5];

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                matrix[i][j] = input.nextInt();
                if (matrix[i][j] == 1) {
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        result = (Math.abs(3 - x)) + (Math.abs(3 - y));
        out.println(result);
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