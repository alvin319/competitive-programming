import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/7/16.
 */

public class Codeforces_round_271_div_2_Keyboard {

    static char[][] matrix;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        matrix = new char[3][10];
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                matrix[i] = "qwertyuiop".toCharArray();
            } else if (i == 1) {
                matrix[i] = "asdfghjkl;".toCharArray();
            } else {
                matrix[i] = "zxcvbnm,./".toCharArray();
            }
        }
        String answer = input.nextLine();
        String decrypt = input.nextLine();
        if (answer.equals("R")) {
            for (int i = 0; i < decrypt.length(); i++) {
                out.print(transform(decrypt.charAt(i), true));
            }
        } else {
            for (int i = 0; i < decrypt.length(); i++) {
                out.print(transform(decrypt.charAt(i), false));
            }
        }
        out.close();
    }

    public static char transform(char current, boolean isRight) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == current) {
                    if (isRight) {
                        return matrix[i][j - 1];
                    } else {
                        return matrix[i][j + 1];
                    }
                }
            }
        }
        return 'a';
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