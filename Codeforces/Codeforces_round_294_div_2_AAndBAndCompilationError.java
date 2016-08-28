import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 8/28/16.
 */

public class Codeforces_round_294_div_2_AAndBAndCompilationError {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int errors = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> secondMap = new HashMap<>();
        for (int i = 0; i < errors; i++) {
            int current = input.nextInt();
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        for (int i = 0; i < errors - 1; i++) {
            int current = input.nextInt();
            int counter = map.get(current) - 1;
            if (counter == 0) {
                map.remove(current);
            } else {
                map.put(current, counter);
            }
            secondMap.put(current, secondMap.containsKey(current) ? secondMap.get(current) + 1 : 1);
        }
        out.println(map.keySet().iterator().next());
        for (int i = 0; i < errors - 2; i++) {
            int current = input.nextInt();
            int counter = secondMap.get(current) - 1;
            if (counter == 0) {
                secondMap.remove(current);
            } else {
                secondMap.put(current, counter);
            }
        }
        out.println(secondMap.keySet().iterator().next());

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