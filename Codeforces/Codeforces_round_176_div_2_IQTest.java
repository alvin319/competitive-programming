import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/9/2017.
 */

public class Codeforces_round_176_div_2_IQTest {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[][] matrix = new char[4][4];
        for (int i = 0; i < 4; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == '#') {
                    int countBR = countBottomRight(i, j, matrix, '#');
                    int countBL = countBottomLeft(i, j, matrix, '#');
                    int countTL = countTopLeft(i, j, matrix, '#');
                    int countTR = countTopRight(i, j, matrix, '#');
                    if (countBR >= 4 || countBL >= 4 || countTL >= 4 || countTR >= 4) {
                        out.println("YES");
                        System.exit(0);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == '.') {
                    int countBR = countBottomRight(i, j, matrix, '.');
                    int countBL = countBottomLeft(i, j, matrix, '.');
                    int countTL = countTopLeft(i, j, matrix, '.');
                    int countTR = countTopRight(i, j, matrix, '.');
                    if (countBR >= 4 || countBL >= 4 || countTL >= 4 || countTR >= 4) {
                        out.println("YES");
                        System.exit(0);
                    }
                }
            }
        }
        out.println("NO");
        out.close();
    }

    static boolean isValid(int i, int j, char[][] matrix, char type) {
        return i >= 0 && j >= 0 && i < 4 && j < 4 && matrix[i][j] == type;
    }

    static int countBottomRight(int i, int j, char[][] matrix, char type) {
        int answer = 0;
        if (isValid(i, j - 1, matrix, type)) {
            answer++;
        }
        if (isValid(i - 1, j - 1, matrix, type)) {
            answer++;
        }
        if (isValid(i - 1, j, matrix, type)) {
            answer++;
        }
        return answer + 2;
    }

    static int countBottomLeft(int i, int j, char[][] matrix, char type) {
        int answer = 0;
        if (isValid(i, j + 1, matrix, type)) {
            answer++;
        }
        if (isValid(i - 1, j, matrix, type)) {
            answer++;
        }
        if (isValid(i - 1, j + 1, matrix, type)) {
            answer++;
        }
        return answer + 2;
    }

    static int countTopLeft(int i, int j, char[][] matrix, char type) {
        int answer = 0;
        if (isValid(i, j + 1, matrix, type)) {
            answer++;
        }
        if (isValid(i + 1, j, matrix, type)) {
            answer++;
        }
        if (isValid(i + 1, j + 1, matrix, type)) {
            answer++;
        }
        return answer + 2;
    }

    static int countTopRight(int i, int j, char[][] matrix, char type) {
        int answer = 0;
        if (isValid(i + 1, j, matrix, type)) {
            answer++;
        }
        if (isValid(i, j - 1, matrix, type)) {
            answer++;
        }
        if (isValid(i + 1, j - 1, matrix, type)) {
            answer++;
        }
        return answer + 2;
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

