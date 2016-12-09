import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/17/16.
 */

public class Codeforces_round_385_div_2_HongcowLearnsTheCyclicShift {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuilder line = new StringBuilder(input.nextLine());
        HashSet<String> set = new HashSet<>();
        while(!set.contains(line.toString())) {
            set.add(line.toString());
            char front = line.charAt(0);
            line = line.append(front);
            line = line.deleteCharAt(0);
        }
        out.println(set.size());
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