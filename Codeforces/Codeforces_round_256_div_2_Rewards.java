import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/15/2017.
 */

public class Codeforces_round_256_div_2_Rewards {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int a1 = input.nextInt();
        int a2 = input.nextInt();
        int a3 = input.nextInt();
        int b1 = input.nextInt();
        int b2 = input.nextInt();
        int b3 = input.nextInt();
        int n = input.nextInt();
        int totalA = a1 + a2 + a3;
        int totalB = b1 + b2 + b3;
        int needed = (int)(Math.ceil((double) totalA / 5) + Math.ceil((double)totalB / 10));
        totalB -= (totalB * 10);
        totalA -= (totalA * 5);
        if (totalA <= 0 && totalB <= 0 && needed <= n) {
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

