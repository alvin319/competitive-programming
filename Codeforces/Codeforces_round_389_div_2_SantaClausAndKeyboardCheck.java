import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 12/25/2016.
 */

public class Codeforces_round_389_div_2_SantaClausAndKeyboardCheck {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String correct = input.nextLine();
        String wrong = input.nextLine();
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> correctMap = new HashMap<>();
        if (correct.length() != wrong.length()) {
            out.println(-1);
        } else {
            for (int i = 0; i < correct.length(); i++) {
                if (correct.charAt(i) != wrong.charAt(i)) {
                    char a = correct.charAt(i);
                    char b = wrong.charAt(i);
                    if (!map.containsKey(a) && !map.containsKey(b) && !map.containsValue(a) && !map.containsValue(b)) {
                        map.put(b, a);
                        correctMap.put(a, b);
                    }
                }
            }
            StringBuilder replace = new StringBuilder(wrong);
            for (int i = 0; i < replace.length(); i++) {
                char current = replace.charAt(i);
                if (map.keySet().contains(current)) {
                    replace.setCharAt(i, map.get(current));
                } else if (correctMap.keySet().contains(current)) {
                    replace.setCharAt(i, correctMap.get(current));
                }
            }
            if (replace.toString().equals(correct)) {
                out.println(map.keySet().size());
                for (char x : map.keySet()) {
                    out.println(x + " " + map.get(x));
                }
            } else {
                out.println(-1);
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

