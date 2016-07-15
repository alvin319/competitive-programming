import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/18/2016.
 */

public class Codeforces_round_295_div_2_Pangram {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Character, Integer> map = new HashMap<>();
        int count = input.nextInt();
        String line = input.nextLine();
        for (int i = 0; i < count; i++) {
            char current = Character.toLowerCase(line.charAt(i));
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if(!map.containsKey((char) i)) {
                out.println("NO");
                System.exit(0);
            }
        }
        out.println("YES");
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

