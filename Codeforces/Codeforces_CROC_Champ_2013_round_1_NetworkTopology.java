import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.concurrent.Exchanger;

/**
 * Created by Alvin on 7/7/2016.
 */

public class Codeforces_CROC_Champ_2013_round_1_NetworkTopology {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int nodes = input.nextInt();
        int edges = input.nextInt();
        int[] connection = new int[nodes];
        for (int i = 0; i < edges; i++) {
            int from = input.nextInt();
            int to = input.nextInt();
            connection[from - 1]++;
            connection[to - 1]++;
        }
        boolean isRing = true;
        boolean isBus = true;
        int count1 = 0;
        int countRest = 0;
        int maxCon = -1;
        for (int i = 0; i < connection.length; i++) {
            maxCon = Math.max(maxCon, connection[i]);
            if (connection[i] != 2) {
                isRing = false;
            }
            if (connection[i] > 2) {
                isBus = false;
            }
            if (connection[i] == 1) {
                count1++;
            } else {
                countRest++;
            }
        }
        if (count1 == nodes - 1 && countRest == 1 && maxCon == nodes - 1) {
            out.println("star topology");
        } else if (isBus && count1 == 2) {
            out.println("bus topology");
        } else if (isRing) {
            out.println("ring topology");
        } else {
            out.println("unknown topology");
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

