import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/31/2016.
 */

public class Codeforces_round_162_div_2_ColorfulStones {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String current = input.nextLine();
        String command = input.nextLine();
        int index = 0;
        for (int i = 0; i < command.length(); i++) {
            char currentCommand = command.charAt(i);
            char currentSpot = current.charAt(index);
            if (currentCommand == currentSpot) {
                index++;
            }
        }
        out.println(index + 1);
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

