import java.io.*;
import java.util.StringTokenizer;

public class Lazy {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int distance = Integer.MAX_VALUE;
            int bestX = 0;
            int bestY = 0;
            int count = input.nextInt();

            for (int j = 0; j < count; j++) {
                int x1 = input.nextInt();
                int y1 = input.nextInt();
                if (distance(x1, y1, x, y) < distance) {
                    distance = distance(x1, y1, x, y);
                    bestX = x1;
                    bestY = y1;
                }
            }
            if (distance == Integer.MAX_VALUE) {
                out.println("(0,0)");
            } else {
                out.println("(" + bestX + "," + bestY + ")");
            }
        }
        out.close();
    }

    public static int distance(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
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