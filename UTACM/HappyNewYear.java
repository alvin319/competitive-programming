import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 9/9/16.
 */

public class HappyNewYear {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int airport = input.nextInt();
            int flight = input.nextInt();
            long[][] dist = new long[airport][airport];
            for (int j = 0; j < airport; j++) {
                Arrays.fill(dist[j], 99999);
            }
            for (int j = 0; j < airport; j++) {
                dist[j][j] = 0;
            }
            for (int j = 0; j < flight; j++) {
                dist[input.nextInt()][input.nextInt()] = 1;
            }
            for (int j = 0; j < airport; j++) {
                for (int k = 0; k < airport; k++) {
                    for (int l = 0; l < airport; l++) {
                        if (dist[k][j] + dist[j][l] < dist[k][l]) {
                            dist[k][l] = dist[k][j] + dist[j][l];
                        }
                    }
                }
            }
            for (int j = 0; j < airport; j++) {
                for (int k = 0; k < airport; k++) {
                    for (int l = 0; l < airport; l++) {
                        if (dist[j][l] != 99999 && dist[k][l] != 99999 && Math.max(dist[j][l], dist[k][l]) < dist[j][k]) {
                            dist[j][k] = Math.max(dist[j][l], dist[k][l]);
                        }
                    }
                }
            }
            long maxCost = Long.MIN_VALUE;
            for (int j = 0; j < dist.length; j++) {
                for (int k = 0; k < dist.length; k++) {
                    maxCost = Math.max(maxCost, dist[j][k]);
                }
            }
            out.println(maxCost == 99999 ? "IMPOSSIBLE" : maxCost);
        }
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