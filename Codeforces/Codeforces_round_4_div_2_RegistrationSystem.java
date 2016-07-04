import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 7/5/2016.
 */

public class Codeforces_round_4_div_2_RegistrationSystem {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<String, Integer> map = new HashMap<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String current = input.nextLine();
            if(!map.containsKey(current)) {
                map.put(current, 0);
                out.println("OK");
            } else {
                int currentValue = map.get(current) + 1;
                out.println(current + currentValue);
                map.put(current, currentValue);
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

