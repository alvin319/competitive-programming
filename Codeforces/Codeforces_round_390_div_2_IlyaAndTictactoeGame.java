import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/17/2017.
 */

public class Codeforces_round_390_div_2_IlyaAndTictactoeGame {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[][] m = new char[4][4];
        for (int i = 0; i < 4; i++) {
            m[i] = input.nextLine().toCharArray();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char c = m[i][j];
                if (c != '.') {
                    continue;
                }

                char[][] copy = m.clone();
                copy[i][j] = 'x';

                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        if (copy[k][l] != 'x') {
                            continue;
                        }
                        if (k - 1 >= 0 && k + 1 <= 3) {
                            if (copy[k - 1][l] == 'x' && copy[k + 1][l] == 'x') {
                                out.println("YES");
                                System.exit(0);
                            }
                        }
                        if (l - 1 >= 0 && l + 1 <= 3) {
                            if (copy[k][l - 1] == 'x' && copy[k][l + 1] == 'x') {
                                out.println("YES");
                                System.exit(0);
                            }
                        }
                        if (k - 1 >= 0 && l - 1 >= 0 && k + 1 <= 3 && l + 1 <= 3) {
                            if (copy[k - 1][l - 1] == 'x' && copy[k + 1][l + 1] == 'x') {
                                out.println("YES");
                                System.exit(0);
                            }
                            if (copy[k - 1][l + 1] == 'x' && copy[k + 1][l - 1] == 'x') {
                                out.println("YES");
                                System.exit(0);
                            }
                        }

                    }
                }

                copy[i][j] = '.';
            }
        }
        out.println("NO");
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

