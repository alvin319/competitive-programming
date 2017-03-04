import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 3/3/2017.
 */

public class Codeforces_round_402_div_2_WeirdRounding {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String[] info = input.nextLine().split(" ");
        String line = info[0];
        int count = Integer.parseInt(info[1]);
        int answer = 0;
        int want = 0;
        for (int i = line.length() - 1; i >= 0; i--) {
            if (want == count) {
                out.println(answer);
                System.exit(0);
            }
            if (line.charAt(i) == '0') {
                want++;
            } else {
                answer++;
            }
        }
        if (line.equals("0") && count == 1) {
            out.println(0);
        } else {
            out.println(line.length() - 1);
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

