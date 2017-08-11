import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_CanadaCup_2016_JumpingBall {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        String line = input.nextLine();
        int leftCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '>') {
                leftCount++;
            } else {
                leftCount = 0;
            }
        }
        int rightCount = 0;
        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) == '<') {
                rightCount++;
            } else {
                rightCount = 0;
            }
        }
        out.println(leftCount + rightCount);
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