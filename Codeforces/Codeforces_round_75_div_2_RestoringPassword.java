import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/31/16.
 */

public class Codeforces_round_75_div_2_RestoringPassword {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String answer = input.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put(input.nextLine(), i);
        }
        int startIndex = 0;
        for (int i = 0; i < 8; i++) {
            out.print(map.get(answer.substring(startIndex, startIndex + 10)));
            startIndex += 10;
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