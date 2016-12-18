import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/18/16.
 */

public class Codeforces_round_386_div_2_Decoding {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuilder answer = new StringBuilder();
        int n = input.nextInt();
        String line = input.nextLine();
        answer = answer.append(line.charAt(0));
        if (line.length() % 2 == 1) {
            for (int i = 1; i < line.length(); i++) {
                if (i % 2 == 1) {
                    answer = answer.insert(0, line.charAt(i));
                } else {
                    answer = answer.append(line.charAt(i));
                }
            }
        } else {
            for (int i = 1; i < line.length(); i++) {
                if (i % 2 == 0) {
                    answer = answer.insert(0, line.charAt(i));
                } else {
                    answer = answer.append(line.charAt(i));
                }
            }
        }
        out.println(answer);
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