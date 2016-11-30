import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/30/16.
 */

public class Codeforces_Technocup_2017_round_2_Spotlights {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[][] matrix = new int[input.nextInt()][input.nextInt()];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] answer = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int[] array = matrix[i];
            int prefix = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 0) {
                    prefix++;
                }
                if (array[j] == 1) {
                    answer[i][j] += prefix;
                    prefix = 0;
                }
            }
            int postfix = 0;
            for (int j = array.length - 1; j >= 0; j--) {
                if (array[j] == 0) {
                    postfix++;
                }
                if (array[j] == 1) {
                    answer[i][j] += postfix;
                    postfix = 0;
                }
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int prefix = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    prefix++;
                }
                if (matrix[j][i] == 1) {
                    answer[j][i] += prefix;
                    prefix = 0;
                }
            }
            int postfix = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (matrix[j][i] == 0) {
                    postfix++;
                }
                if (matrix[j][i] == 1) {
                    answer[j][i] += postfix;
                    postfix = 0;
                }
            }
        }
        long total = 0;
        for (int i = 0; i < answer.length; i++) {
            total += Arrays.stream(answer[i]).sum();
        }
        out.println(total);
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