import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/5/16.
 */

public class Codeforces_round_297_div_2_VitaliyAndPie {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        char[] array = input.nextLine().toCharArray();
        HashMap<Character, Integer> key = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLowerCase(array[i])) {
                key.put(array[i], key.containsKey(array[i]) ? key.get(array[i]) + 1 : 1);
            } else {
                char lower = Character.toLowerCase(array[i]);
                if (!key.containsKey(lower)) {
                    answer++;
                } else {
                    int y = key.get(lower) - 1;
                    if (y <= 0) {
                        key.remove(lower);
                    } else {
                        key.put(lower, y);
                    }
                }
            }
        }
        out.println(answer);
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