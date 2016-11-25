import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/23/16.
 */

public class Codeforces_round_381_div_2_AlyonaAndCopybooks {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        if (n % 4 == 0) {
            out.println(0);
        } else {
            long start = n / 4;
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                long total = (start + i) * 4;
                list.add(total);
            }
            long minimum = Integer.MAX_VALUE;
            for (long currentCost : list) {
                long remain = currentCost - n;
                if (remain > 0) {
                    long firstCost = remain * a;
                    long secondCost = (remain / 2) * b + (remain % 2) * a;
                    long thirdCost = (remain / 3) * c + (remain % 3) * a;
                    long fourthCost = (remain / 3) * c + ((remain % 3) / 2) * b +
                            ((remain % 3) % 2) * a;
                    minimum = Math.min(minimum, Math.min(firstCost, Math.min(secondCost, Math.min(thirdCost, fourthCost))));
                }
            }
            out.println(minimum);
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