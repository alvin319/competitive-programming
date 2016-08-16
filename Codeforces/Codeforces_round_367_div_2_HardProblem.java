import java.io.*;
import java.util.StringTokenizer;
/**
 * Created by alvin on 8/16/16.
 */
public class Codeforces_round_367_div_2_HardProblem {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long[][] matrix = new long[input.nextInt()][2];
        long[] cost = new long[matrix.length];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = input.nextLong();
        }
        String[] array = new String[cost.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextLine();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = Long.MAX_VALUE / 2;
            }
        }
        matrix[0][0] = 0;
        matrix[0][1] = cost[0];
        for (int i = 1; i < matrix.length; i++) {
            String currentSwap = new StringBuilder(array[i]).reverse().toString();
            String previousSwap = new StringBuilder(array[i - 1]).reverse().toString();
            boolean notpossible = true;
            if (array[i].compareTo(array[i - 1]) >= 0) {
                matrix[i][0] = matrix[i - 1][0];
                notpossible = false;
            }
            if (array[i].compareTo(previousSwap) >= 0) {
                matrix[i][0] = Math.min(matrix[i][0], matrix[i - 1][1]);
                notpossible = false;
            }
            if (currentSwap.compareTo(array[i - 1]) >= 0) {
                matrix[i][1] = Math.min(matrix[i][1], matrix[i - 1][0] + cost[i]);
                notpossible = false;
            }
            if (currentSwap.compareTo(previousSwap) >= 0) {
                matrix[i][1] = Math.min(matrix[i][1], matrix[i - 1][1] + cost[i]);
                notpossible = false;
            }
            if (notpossible) {
                out.println(-1);
                System.exit(0);
            }
        }
        out.println(Math.min(matrix[matrix.length - 1][0], matrix[matrix.length - 1][1]) == Long.MAX_VALUE / 2 ? -1 : Math.min(matrix[matrix.length - 1][0], matrix[matrix.length - 1][1]));
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
