import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/19/16.
 */

public class CodeJam2016_round_1A_RankAndFile {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int next = input.nextInt() * 2 - 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < next; j++) {
                String[] array = input.nextLine().split(" ");
                for (int k = 0; k < array.length; k++) {
                    if (!map.containsKey(i(array[k]))) {
                        map.put(i(array[k]), 1);
                    } else {
                        map.put(i(array[k]), map.get(i(array[k])) + 1);
                    }
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int x : map.keySet()) {
                if (map.get(x) % 2 != 0) {
                    list.add(x);
                }
            }
            Collections.sort(list);
            out.print("Case #" + (i+1) + ": " + list.get(0));
            for (int j = 1; j < list.size(); j++) {
                out.print(" " + list.get(j));
            }
            out.println();
        }

        out.close();
    }

    public static int i(String x) {
        return Integer.parseInt(x);
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