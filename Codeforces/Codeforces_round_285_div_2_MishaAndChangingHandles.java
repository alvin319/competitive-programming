import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WiNDWAY on 8/30/16.
 */

public class Codeforces_round_285_div_2_MishaAndChangingHandles {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int m = input.nextInt();
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            String[] array = input.nextLine().split(" ");
            String first = array[0];
            String second = array[1];
            if (!map.containsKey(first) && !map.containsValue(first)) {
                map.put(first, second);
            } else if (map.containsValue(first)) {
                for (String current : map.keySet()) {
                    if (map.get(current).equals(first)) {
                        map.put(current, second);
                        break;
                    }
                }
            }
        }
        out.println(map.keySet().size());
        for (String current : map.keySet()) {
            out.println(current + " " + map.get(current));
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