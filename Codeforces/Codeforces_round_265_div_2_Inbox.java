/**
 * Created by qicodeng on 11/22/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_265_div_2_Inbox {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                int count = 1;
                i++;
                while (i < array.length) {
                    if (array[i] == 1) {
                        i++;
                        count++;
                    } else {
                        break;
                    }
                }
                total += count + 1;
            }
        }
        out.println(total == 0 ? 0 : total - 1);
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
