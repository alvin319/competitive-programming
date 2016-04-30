import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/30/16.
 */

public class Codeforces_Educational_round_4_HDDIsOutdatedTechnology {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int fragments = input.nextInt();
        HashMap<Long, Long> map = new HashMap<>();
        long index = 1;
        for (int i = 0; i < fragments; i++) {
            map.put(input.nextLong(), index);
            index++;
        }
        long total = 0;
        long starting = map.get(new Long(1));
        for (long i = 1; i <= fragments; i++) {
            long next = map.get(i);
            total += Math.abs(starting - next);
            starting = next;
        }
        out.println(total);
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