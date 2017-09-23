import java.io.*;
import java.util.StringTokenizer;


public class Codeforces_Educational_round_29_QuasiPalindrome {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        int end = -1;
        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) == '0') {
                end = i;
            } else {
                break;
            }
        }
        if (end != -1) {
            line = line.substring(0, end);
        }
        out.println(isPalindrome(line) ? "YES" : "NO");
        out.close();
    }

    static boolean isPalindrome(String line) {
        int start = 0;
        int end = line.length() - 1;
        while (start < end) {
            if (line.charAt(start) != line.charAt(end)) {
                return false;
            }
            start++;
            end--;
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