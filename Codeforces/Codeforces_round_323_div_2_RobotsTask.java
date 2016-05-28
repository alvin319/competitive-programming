import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/27/2016.
 */

public class Codeforces_round_323_div_2_RobotsTask {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] pieces = new int[input.nextInt()];
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = input.nextInt();
        }
        int collected = 0;
        int turns = 0;
        int i = 0;
        boolean forward = true;
        boolean init = true;
        boolean[] visited = new boolean[pieces.length];
        while(collected < pieces.length) {
            if(pieces[i] <= collected && !visited[i]) {
                collected++;
                visited[i] = true;
            }
            if(collected < pieces.length) {
                if (i == 0 && !init) {
                    forward = true;
                    turns++;
                } else if (i == pieces.length - 1) {
                    forward = false;
                    turns++;
                    init = false;
                }
            }
            i = forward ? i + 1 : i - 1;
        }
        out.println(turns);
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

