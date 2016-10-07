/**
 * Created by qicodeng on 10/3/16.
 */

import java.io.*;
import java.util.StringTokenizer;

public class Codeforces_round_375_div_2_TextDocumentAnalysis {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String line = input.nextLine();
        line = line.replaceAll("\\(", "_(_");
        line = line.replaceAll("\\)", "_)_");
        line = line.replaceAll("_+", "_");
        String[] info = line.split("_");
        boolean parenMode = false;
        int maxLength = 0;
        int counter = 0;
        for (int i = 0; i < info.length; i++) {
            String current = info[i];
            if (current.equals("(")) {
                parenMode = true;
            } else if (current.equals(")")) {
                parenMode = false;
            } else if (parenMode) {
                counter++;
            } else {
                maxLength = Math.max(maxLength, current.length());
            }
        }
        out.println(maxLength + " " + counter);
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
