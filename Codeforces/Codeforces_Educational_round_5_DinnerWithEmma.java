import java.io.*;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/22/16.
 */

public class Codeforces_Educational_round_5_DinnerWithEmma {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int row = input.nextInt();
        int col = input.nextInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        int highestVal = -1;
        int highestRowIndex = -1;
        int highestRowLowVal = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int lowestRow = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if(current > highestVal) {
                    highestVal = current;
                    highestRowIndex = i;
                }
                if(highestRowIndex == i) {
                    highestRowLowVal = Math.min(highestRowLowVal, current);
                }
                lowestRow = Math.min(lowestRow, current);
            }
            set.add(lowestRow);
        }
        for(int x : set) {
            highestRowLowVal = Math.max(highestRowLowVal, x);
        }
        out.println(highestRowLowVal);
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