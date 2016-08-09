import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/8/2016.
 */

public class Codeforces_round_177_div_1_PoloThePenguinAndStrings {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int length = input.nextInt();
        int charCount = input.nextInt();
        if (charCount > length || (charCount == 1 && length > 1)) {
            out.println(-1);
        } else {
            StringBuilder solution = new StringBuilder();
            solution.append('a');
            for (int i = 2; i <= length; i++) {
                solution.append(i % 2 == 0 ? 'b' : 'a');
            }
            char next = 'c';
            if (charCount > 2) {
                for (int i = length - charCount + 2; i < length; i++) {
                    solution.setCharAt(i, next);
                    next = (char)((int)next + 1);
                }
            }
            out.println(solution);
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

