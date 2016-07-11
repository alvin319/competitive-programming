import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/12/2016.
 */

public class Codeforces_round_249_div_2_QueueOnBusStop {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        int maxBus = input.nextInt();
        int busCount = 0;
        int currentLoad = 0;
        for (int i = 0; i < count; i++) {
            int current = input.nextInt();
            if(currentLoad + current <= maxBus) {
                currentLoad += current;
            } else {
                busCount++;
                currentLoad = current;
            }
        }
        out.println(busCount + 1);
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

