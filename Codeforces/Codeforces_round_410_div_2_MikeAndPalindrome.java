import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/22/2017.
 */

public class Codeforces_round_410_div_2_MikeAndPalindrome {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int startIndex = 0;
        int endIndex = line.length() - 1;
        int count = 0;
        while (startIndex < endIndex) {
            if (line.charAt(startIndex) != line.charAt(endIndex)) {
                count++;
            }
            startIndex++;
            endIndex--;
        }
        if (count == 1 || (count == 0 && line.length() % 2 == 1)) {
            out.println("YES");
        } else {
            out.println("NO");
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

