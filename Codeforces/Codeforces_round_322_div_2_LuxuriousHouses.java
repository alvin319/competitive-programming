import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/20/2016.
 */

public class Codeforces_round_322_div_2_LuxuriousHouses {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] houses = new int[input.nextInt()];
        int[] biggest = new int[houses.length + 1];
        for (int i = 0; i < houses.length; i++) {
            houses[i] = input.nextInt();
        }
        biggest[houses.length - 1] = -1;
        int previousBest = houses[houses.length - 1];
        for (int i = houses.length - 2; i >= 0; i--) {
            biggest[i] = previousBest;
            previousBest = Math.max(previousBest, houses[i]);
        }
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] <= biggest[i]) {
                out.print(biggest[i] - houses[i] + 1 + " ");
            } else {
                out.print(0 + " ");
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

