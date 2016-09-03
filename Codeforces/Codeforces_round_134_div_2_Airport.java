import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/2/16.
 */

public class Codeforces_round_134_div_2_Airport {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int passenger = input.nextInt();
        int[] maxTickets = new int[input.nextInt()];
        int[] minTickets = new int[maxTickets.length];
        for (int i = 0; i < maxTickets.length; i++) {
            maxTickets[i] = input.nextInt();
            minTickets[i] = maxTickets[i];
        }
        int maxCost = 0;
        for (int i = 0; i < passenger; i++) {
            int currentCost = 0;
            int currentCostIndex = -1;
            for (int j = 0; j < maxTickets.length; j++) {
                if (maxTickets[j] > currentCost) {
                    currentCost = maxTickets[j];
                    currentCostIndex = j;
                }
            }
            maxTickets[currentCostIndex]--;
            maxCost += currentCost;
        }
        int minCost = 0;
        for (int i = 0; i < passenger; i++) {
            int currentCost = Integer.MAX_VALUE;
            int currentCostIndex = -1;
            for (int j = 0; j < minTickets.length; j++) {
                if (minTickets[j] < currentCost && minTickets[j] != 0) {
                    currentCost = minTickets[j];
                    currentCostIndex = j;
                }
            }
            minTickets[currentCostIndex]--;
            minCost += currentCost;
        }
        out.println(maxCost + " " + minCost);
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