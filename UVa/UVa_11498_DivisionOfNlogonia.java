import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class UVa_11498_DivisionOfNlogonia {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        while(count != 0) {
            int xDiv = input.nextInt();
            int yDiv = input.nextInt();
            for (int i = 0; i < count; i++) {
                int x = input.nextInt();
                int y = input.nextInt();
                if(x == xDiv || yDiv == y) {
                    out.println("divisa");
                } else if(x > xDiv && y > yDiv) {
                    out.println("NE");
                } else if(x < xDiv && y > yDiv) {
                    out.println("NO");
                } else if(x > xDiv && y < yDiv) {
                    out.println("SE");
                } else {
                    out.println("SO");
                }
            }
            count = input.nextInt();
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