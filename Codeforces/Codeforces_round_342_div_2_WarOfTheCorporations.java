import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/19/2016.
 */

public class Codeforces_round_342_div_2_WarOfTheCorporations {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String text = input.nextLine();
        String pattern = input.nextLine();
        out.println(func(text, pattern));
        out.close();
    }

    public static int func(String text, String p) {
        if(text.length() == 0 || p.length() == 0) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while((index = text.indexOf(p, index)) >= 0) {
            count++;
            index += p.length();
        }
        return count;
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