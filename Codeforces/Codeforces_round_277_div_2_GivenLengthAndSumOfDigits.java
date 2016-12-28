import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/27/16.
 */

public class Codeforces_round_277_div_2_GivenLengthAndSumOfDigits {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int m = input.nextInt();
        int s = input.nextInt();

        int[] max = new int[m];
        int[] min = new int[m];

        Arrays.fill(max, 9);
        if (m != 1) {
            min[0] = 1;
        }

        int maxc = 9 * m;
        int minc = 1;
        if (m == 1) {
            minc = 0;
        }

        if (s > 9 * m || s < minc) {
            System.out.println("-1 -1");
            return;
        }

        for (int i = m - 1; i >= 0; i--) {
            while (maxc > s && max[i] > 0) {
                max[i]--;
                maxc--;
            }
            if (maxc == s) {
                break;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            while (minc < s && min[i] < 9) {
                min[i]++;
                minc++;
            }
            if (minc == s) {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            out.print(min[i]);
        }

        out.print(" ");
        for (int i = 0; i < m; i++) {
            out.print(max[i]);
        }

        out.println();
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