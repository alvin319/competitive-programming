import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_408_div_2_FindTheBone {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int h = input.nextInt();
        int k = input.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < h; i++) {
            set.add(input.nextInt());
        }
        int start = 1;
        if (set.contains(start)) {
            out.println(start);
        } else {
            for (int i = 0; i < k; i++) {
                int from = input.nextInt();
                int to = input.nextInt();
                if (from == start) {
                    start = to;
                } else if (to == start) {
                    start = from;
                }
                if (set.contains(start)) {
                    break;
                }
            }
            out.println(start);
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