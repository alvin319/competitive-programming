import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 4/12/2017.
 */

public class Codeforces_round_310_div_2_CaseOfTheZerosAndOnes {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String line = input.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        if (n == 1) {
            out.println(1);
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < line.length(); i++) {
                map.put(line.charAt(i), map.containsKey(line.charAt(i)) ? map.get(line.charAt(i)) + 1 : 1);
            }
            if (map.keySet().size() == 1) {
                out.println(n);
            } else {
                for (Character k : map.keySet()) {
                    min = Math.min(min, map.get(k));
                }
                out.println(line.length() - (2 * min));
            }
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

