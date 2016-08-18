import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by alvin on 8/17/16.
 */
public class Codeforces_round_312_div_2_AmrAndTheLargeArray {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Pair> indexMap = new HashMap<>();
        int highest = -1;
        int highestCount = -1;
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
            if (!indexMap.containsKey(current)) {
                Pair currentPair = new Pair(i, i);
                indexMap.put(current, currentPair);
            } else {
                Pair currentPair = indexMap.get(current);
                currentPair.end = i;
                indexMap.put(current, currentPair);
            }
            if (map.get(current) > highestCount) {
                highest = current;
                highestCount = map.get(current);
            } else if (map.get(current) == highestCount) {
                Pair indexPair = indexMap.get(highest);
                Pair currentPair = indexMap.get(current);
                if (indexPair.end - indexPair.start > currentPair.end - currentPair.start) {
                    highest = current;
                }
            }
        }
        out.println(indexMap.get(highest).start + 1 + " " + (indexMap.get(highest).end + 1));
        out.close();
    }

    static class Pair {
        int start;
        int end;

        public Pair (int start, int end) {
            this.start = start;
            this.end = end;
        }
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
