import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/6/16.
 */

public class Codeforces_round_378_div_2_Parade {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[][] m = new int[n][2];
        int b = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            m[i][0] = input.nextInt();
            m[i][1] = input.nextInt();
            x += m[i][0];
            y += m[i][1];
        }
        b = Math.abs(x - y);
        int index = -1;
        int currentMax = b;
        for (int i = 0; i < m.length; i++) {
            int newB = Math.abs((x - m[i][0] + m[i][1]) - (y - m[i][1] + m[i][0]));
            if (newB > currentMax) {
                currentMax = newB;
                index = i;
            }
        }
        out.println(index == -1 ? 0 : index + 1);
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