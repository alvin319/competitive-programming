import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by alvin on 6/2/16.
 */

public class Codeforces_round_306_div_2_DivisibilityByEight {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = line.length() - 1; i >= 0; i--) {
            int x = (line.charAt(i) - '0');
            if (x == 0 || x == 8) {
                done(x);
            }
        }
        for (int i = line.length() - 1; i >= 0; i--) {
            int x = (line.charAt(i) - '0');
            for (int j = i - 1; j >= 0; j--) {
                int y = (line.charAt(j) - '0');
                if((y * 10 + x) % 8 == 0 && y != 0) {
                    done(y * 10 + x);
                }
            }
        }
        for (int i = line.length() - 1; i >= 0; i--) {
            int x = (line.charAt(i) - '0');
            for (int j = i - 1; j >= 0; j--) {
                int y = (line.charAt(j) - '0');
                for (int k = j - 1; k >= 0; k--) {
                    int z = (line.charAt(k) - '0');
                    if((z * 100 + y * 10 + x) % 8 == 0 && z != 0) {
                        done(z * 100 + y * 10 + x);
                    }
                }
            }
        }
        out.println("NO");

    }

    public static void done(int result) {
        out.println("YES");
        out.println(result);
        System.exit(0);
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
