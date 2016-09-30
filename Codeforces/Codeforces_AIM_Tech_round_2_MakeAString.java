/**
 * Created by qicodeng on 9/29/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_AIM_Tech_round_2_MakeAString {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        long solution = 0;
        for (int i = 0; i < count; i++) {
            int num = input.nextInt();
            if (!set.contains(num)) {
                solution += num;
                set.add(num);
            } else {
                num -= 1;
                while (set.contains(num)) {
                    num--;
                }
                if (num >= 0) {
                    solution += num;
                    set.add(num);
                }
            }
        }
        out.println(solution);
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
