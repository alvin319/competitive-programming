import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/8/2016.
 */

public class Codeforces_round_190_div_2_CielAndDancing {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int boys = input.nextInt();
        int girls = input.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        boolean[] bA = new boolean[boys];
        boolean[] gA = new boolean[girls];
        for (int i = 0; i < boys; i++) {
            for (int j = 0; j < girls; j++) {
                boolean bState = bA[i];
                boolean gState = gA[j];
                if (!bState || !gState) {
                    list.add(new Pair(i + 1, j + 1));
                    bA[i] = true;
                    gA[j] = true;
                }
            }
        }
        out.println(list.size());
        for (Pair x : list) {
            out.println(x.start + " " + x.end);
        }
        out.close();
    }

    static class Pair {
        int start;
        int end;

        public Pair (int start, int end) {
            this.start = start;
            this.end = end;
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

