import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/4/2016.
 */

public class Codeforces_round_130_div_2_DubStep {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        current = current.replaceAll("WUB", " ");
        String[] array = current.split(" ");
        String answer = "";
        for (int i = 0; i < array.length; i++) {
            if(array[i].length() != 0) {
                answer += array[i] + " ";
            }
        }
        out.println(answer.substring(0, answer.length() - 1));
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

