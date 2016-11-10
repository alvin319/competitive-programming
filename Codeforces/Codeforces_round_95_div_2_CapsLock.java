import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/13/16.
 */

public class Codeforces_round_95_div_2_CapsLock {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        boolean onlyUpper = true;
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLowerCase(line.charAt(i))) {
                onlyUpper = false;
            }
        }
        boolean restUpper = true;
        for (int i = 1; i < line.length(); i++) {
            if (Character.isLowerCase(line.charAt(i))) {
                restUpper = false;
            }
        }
        restUpper = restUpper && Character.isLowerCase(line.charAt(0));
        if (onlyUpper || restUpper) {
            String answer = "";
            for (int i = 0; i < line.length(); i++) {
                answer += Character.isUpperCase(line.charAt(i)) ? Character.toLowerCase(line.charAt(i)) : Character.toUpperCase(line.charAt(i));
            }
            out.println(answer);
        } else {
            out.println(line);
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