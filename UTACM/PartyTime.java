import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 9/12/2016.
 */

public class PartyTime {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int F = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            int[] xList = new int[F + 1];
            xList[0] = x;
            int[] yList = new int[F + 1];
            yList[0] = y;
            for (int j = 1; j < xList.length; j++) {
                xList[j] = input.nextInt();
                yList[j] = input.nextInt();
            }
            Arrays.sort(xList);
            Arrays.sort(yList);
            out.println(xList[xList.length / 2] + " " + yList[yList.length / 2]);
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

