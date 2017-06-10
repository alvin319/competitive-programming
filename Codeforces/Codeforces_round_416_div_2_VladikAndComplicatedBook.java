/**
 * Created by WiNDWAY on 6/10/2017.
 */

import java.io.*;
import java.util.*;

public class Codeforces_round_416_div_2_VladikAndComplicatedBook {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int l = input.nextInt() - 1;
            int r = input.nextInt() - 1;
            int x = input.nextInt() - 1;
            if (x >= l && x <= r) {
                int count = 0;
                for (int j = l; j <= r; j++) {
                    if (array[j] < array[x]) {
                        count++;
                    }
                }
                out.println(l + count == x ? "Yes" : "No");
            } else {
                out.println("Yes");
            }
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

