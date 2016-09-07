import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 9/6/2016.
 */

public class Codeforces_round_305_div_2_MikeAndFax {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        int k = input.nextInt();
        if (current.length() % k != 0) {
            out.println("NO");
        } else {
            int palindromeCount = 0;
            int remainLength = current.length() / k;
            int currentIndex = 0;
            for (int i = 1; i <= k; i++) {
                String substring = current.substring(currentIndex, currentIndex + remainLength);
                palindromeCount += isPalindrome(substring) ? 1 : 0;
                currentIndex += remainLength;
            }
            if (palindromeCount == k) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.close();
    }

    public static boolean isPalindrome(String check) {
        int s = 0;
        int e = check.length() - 1;
        while (s <= e) {
            char S = check.charAt(s);
            char E = check.charAt(e);
            if (S != E) {
                return false;
            }
            s++;
            e--;
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

