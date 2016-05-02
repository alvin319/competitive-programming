import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/1/2016.
 */

public class Codeforces_LookseryCup_2015_FaceDetection {

    static char[][] matrix;
    static int row;
    static int col;
    static HashSet<Character> set;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        row = input.nextInt();
        col = input.nextInt();
        set = new HashSet<>();
        set.add('a');
        set.add('c');
        set.add('e');
        matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
        long total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == 'f') {
                    total += getFace(i, j);
                }
            }
        }
        out.println(total);
        out.close();
    }

    public static int getFace(int x, int y) {
        int result = 0;
        // fa
        // ce
        HashSet<Character> check = (HashSet<Character>)set.clone();
        if(y + 1 < col && x + 1 < row) {
            char right = matrix[x][y + 1];
            char bottom = matrix[x + 1][y];
            char across = matrix[x + 1][y + 1];
            if(check.remove(right) && check.remove(bottom) && check.remove(across)) {
                result++;
            }
        }
        // ce
        // fa
        check = (HashSet<Character>)set.clone();
        if(x - 1 >= 0 && y + 1 < col) {
            char up = matrix[x - 1][y];
            char right = matrix[x][y + 1];
            char across = matrix[x - 1][y + 1];
            if(check.remove(up) && check.remove(right) && check.remove(across)) {
                result++;
            }
        }
        // ce
        // af
        check = (HashSet<Character>)set.clone();
        if(y - 1 >= 0 && x - 1 >= 0) {
            char up = matrix[x - 1][y];
            char left = matrix[x][y - 1];
            char across = matrix[x - 1][y - 1];
            if(check.remove(up) && check.remove(left) && check.remove(across)) {
                result++;
            }
        }
        // af
        // ce
        check = (HashSet<Character>)set.clone();
        if(y - 1 >= 0 && x + 1 < row) {
            char bottom = matrix[x + 1][y];
            char left = matrix[x][y - 1];
            char across = matrix[x + 1][y - 1];
            if(check.remove(bottom) && check.remove(left) && check.remove(across)) {
                result++;
            }
        }
        return result;
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

