import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/16/2017.
 */

public class Codeforces_round_391_div_2_GottaCatchEmAll {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = input.nextLine().toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        int min = 0;
        String answer = "Bulbasaur";
        HashMap<Character, Integer> compare = new HashMap<>();
        for (int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            compare.put(c, compare.containsKey(c) ? compare.get(c) + 1 : 1);
        }
        boolean running = true;
        while (running) {
            for (char x : compare.keySet()) {
                if (!map.containsKey(x) || map.get(x) < compare.get(x)) {
                    running = false;
                    break;
                } else {
                    if (map.get(x).equals(compare.get(x))) {
                        map.remove(x);
                    } else {
                        map.put(x, map.get(x) - compare.get(x));
                    }
                }
            }
            if (running) {
                min++;
            }
        }
        out.println(min);
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

