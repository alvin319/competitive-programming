import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by alvin on 6/17/16.
 */
public class Codeforces_round_215_div_2_SerejaAndSuffixes {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        int m  = input.nextInt();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        int[] solutions = new int[array.length];
        for (int i = solutions.length - 1; i >= 0; i--) {
            int current = array[i];
            set.add(current);
            solutions[i] = set.size();
        }
        for (int i = 0; i < m; i++) {
            out.println(solutions[input.nextInt() - 1]);
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
