import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/18/2016.
 */

public class Codeforces_round_344_div_2_PrintCheck {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int mRow = input.nextInt();
        int mCol = input.nextInt();
        int[][] matrix = new int[mRow][mCol];
        int count = input.nextInt();
        int[] commands = new int[count];
        int[] location = new int[count];
        int[] colors = new int[count];
        boolean[] rowOp = new boolean[mRow];
        boolean[] colOp = new boolean[mCol];
        for (int i = 0; i < count; i++) {
            commands[i] = input.nextInt();
            location[i] = input.nextInt() - 1;
            colors[i] = input.nextInt();
        }

        for (int i = commands.length - 1; i >= 0; i--) {
            if(commands[i] == 1) {
                if(!rowOp[location[i]]) {
                    for (int j = 0; j < mCol; j++) {
                        if(matrix[location[i]][j] == 0) {
                            matrix[location[i]][j] = colors[i];
                        }
                    }
                    rowOp[location[i]] = true;
                }
            } else {
                if(!colOp[location[i]]) {
                    for (int j = 0; j < mRow; j++) {
                        if(matrix[j][location[i]] == 0) {
                            matrix[j][location[i]] = colors[i];
                        }
                    }
                    colOp[location[i]] = true;
                }
            }
        }

        for (int i = 0; i < mRow; i++) {
            for (int j = 0; j < mCol; j++) {
                out.print(matrix[i][j] + " ");
            }
            out.println();
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

