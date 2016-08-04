import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by alvin on 8/2/16.
 */

public class Codeforces_round_110_div_2_GameOutcome {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        HashMap<Integer, Integer> rowSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
                sum += matrix[i][j];
            }
            rowSum.put(i, sum);
        }
        HashMap<Integer, Integer> colSum = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[j][i];
            }
            colSum.put(i, sum);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currentRow = rowSum.get(i);
                int currentCol = colSum.get(j);
                if (currentCol > currentRow) {
                    answer++;
                }
            }
        }
        out.println(answer);

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
