import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/12/16.
 */

public class Codeforces_round_351_div_2_ProblemsForRound {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int problems = input.nextInt();
        int pairs = input.nextInt();
        int[][] matrix = new int[pairs][2];
        for (int i = 0; i < pairs; i++) {
            matrix[i][0] = input.nextInt();
            matrix[i][1] = input.nextInt();
        }
        int div1S = Integer.MAX_VALUE;
        int div2B = Integer.MIN_VALUE;
        for (int i = 0; i < pairs; i++) {
            int first = matrix[i][0];
            int second = matrix[i][1];
            int best = Math.max(first, second);
            int worst = Math.min(second, first);
            div1S = Math.min(best, div1S);
            div2B = Math.max(worst, div2B);
        }
        if(pairs == 0) {
            out.println(problems - 1);
        } else {
            out.println(Math.max(0, div1S - div2B));
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