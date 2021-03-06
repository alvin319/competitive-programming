import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/13/16.
 */
public class Codeforces_Educational_round_8_NewSkateboard {
    public static void main(String[] args) throws IOException {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        long total = 0;
        total += (int)current.charAt(0) % 4 == 0 ? 1 : 0;
        for (int i = 1; i < current.length(); i++) {
            int now = (int)current.charAt(i) - 48;
            total += now % 4 == 0 ? 1 : 0;
            now += (10 * (((int)current.charAt(i - 1)) - 48));
            if(now % 4 == 0) {
                total += (i - 1);
                total += 1;
            }
        }
        System.out.println(total);
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