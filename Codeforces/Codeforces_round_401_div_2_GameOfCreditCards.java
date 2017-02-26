import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Codeforces_round_401_div_2_GameOfCreditCards {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String sherlock = input.nextLine();
        String moriaty = input.nextLine();
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < moriaty.length(); i++) {
            map1.compute(moriaty.charAt(i) - '0', (k, v) -> map1.containsKey(k) ? v + 1 : 1);
            map2.compute(moriaty.charAt(i) - '0', (k, v) -> map2.containsKey(k) ? v + 1 : 1);
        }
        int min = 0;
        for (int i = 0; i < sherlock.length(); i++) {
            int digit = sherlock.charAt(i) - '0';
            Integer answer = map1.ceilingKey(digit);
            if (answer != null) {
                if (map1.get(answer) == 1) {
                    map1.remove(answer);
                } else {
                    map1.put(answer, map1.get(answer) - 1);
                }
            } else {
                min++;
            }
        }
        int max = 0;
        for (int i = 0; i < sherlock.length(); i++) {
            int digit = sherlock.charAt(i) - '0';
            Integer answer = map2.ceilingKey(digit + 1);
            if (answer != null) {
                if (map2.get(answer) == 1) {
                    map2.remove(answer);
                } else {
                    map2.put(answer, map2.get(answer) - 1);
                }
                max++;
            } else {
                max += 0;
            }
        }
        out.println(min);
        out.println(max);
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