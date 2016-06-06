import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 6/5/16.
 */

public class Codeforces_round_87_div_2_LittlePigsAndWolves {

    static int rows;
    static int columns;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        rows = input.nextInt();
        columns = input.nextInt();
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
        boolean[][] visited = new boolean[rows][columns];
        int total = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char current = matrix[i][j];
                if(current == 'P') {
                    if(isValid(i + 1, j) && matrix[i + 1][j] == 'W') {
                        if(!visited[i + 1][j]) {
                            total++;
                            visited[i + 1][j] = true;
                        }
                    } else if(isValid(i - 1, j) && matrix[i - 1][j] == 'W') {
                        if(!visited[i - 1][j]) {
                            total++;
                            visited[i - 1][j] = true;
                        }
                    } else if(isValid(i, j + 1) && matrix[i][j + 1] == 'W') {
                        if(!visited[i][j + 1]) {
                            total++;
                            visited[i][j + 1] = true;
                        }
                    } else if(isValid(i, j - 1) && matrix[i][j - 1] == 'W') {
                        if(!visited[i][j - 1]) {
                            total++;
                            visited[i][j - 1] = true;
                        }
                    }
                }
            }
        }
        out.println(total);
        out.close();
    }

    public static boolean isValid(int x, int y) {
        if(x < 0 || y < 0 || x >= rows || y >= columns) {
            return false;
        }
        return true;
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