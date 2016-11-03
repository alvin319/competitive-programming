import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/5/16.
 */

public class Codeforces_round_294_div_2_AAndBAndChess {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('q', 9);
        m.put('r', 5);
        m.put('b', 3);
        m.put('n', 3);
        m.put('p', 1);
        int a = 0;
        int b = 0;
        for (int i = 0; i < 8; i++) {
            char[] array = input.nextLine().toCharArray();
            for (int j = 0; j < array.length; j++) {
                if (Character.isUpperCase(array[j])) {
                    a += m.containsKey(Character.toLowerCase(array[j])) ? m.get(Character.toLowerCase(array[j])) : 0;
                } else {
                    b += m.containsKey(array[j]) ? m.get(array[j]) : 0;
                }
            }
        }
        if (a > b) {
            out.println("White");
        } else  if (a < b) {
            out.println("Black");
        } else {
            out.println("Draw");
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