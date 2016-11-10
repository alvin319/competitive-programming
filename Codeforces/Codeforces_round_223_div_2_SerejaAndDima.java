import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/13/16.
 */

public class Codeforces_round_223_div_2_SerejaAndDima {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        ArrayDeque<Integer> list = new ArrayDeque<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        int a = 0;
        int b = 0;
        int iter = 0;
        while (!list.isEmpty()) {
            int first = list.getFirst();
            int last = list.getLast();
            if (first > last) {
                if (iter == 0) {
                    a += first;
                    list.removeFirst();
                    iter = 1;
                } else {
                    iter = 0;
                    b += first;
                    list.removeFirst();
                }
            } else {
                if (iter == 0) {
                    a += last;
                    list.removeLast();
                    iter = 1;
                } else  {
                    b += last;
                    list.removeLast();
                    iter = 0;
                }
            }
        }
        out.println(a + " " + b);
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