import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 9/20/16.
 */

public class Codeforces_round_314_div_2_BerlandNationalLibrary {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int answer = 0;
        int state = 0;
        boolean[] visited = new boolean[1000005];
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            String[] line = input.nextLine().split(" ");
            int value = Integer.parseInt(line[1]);
            switch (line[0]) {
                case "+": {
                    visited[value] = true;
                    state++;
                    answer = Math.max(state, answer);
                }
                break;
                default: {
                    if (visited[value]) {
                        state--;
                    } else {
                        answer++;
                    }
                    visited[value] = false;
                }
            }
        }
        out.println(Math.max(answer, state));
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