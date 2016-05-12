import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/11/2016.
 */

public class Codeforces_round_352_div_2_DifferentIsGood {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int length = input.nextInt();
        if(length > 26) {
            out.println(-1);
        } else {
            String current = input.nextLine();
            HashMap<Character, Integer> freqMap = new HashMap<>();
            long answer = 0;
            for (int i = 0; i < current.length(); i++) {
                char c = current.charAt(i);
                if (!freqMap.containsKey(c)) {
                    freqMap.put(c, 1);
                } else {
                    answer++;
                    freqMap.put(c, freqMap.get(c) + 1);
                }
            }
            out.println(answer);
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

