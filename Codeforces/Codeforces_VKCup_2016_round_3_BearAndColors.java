import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/9/16.
 */

public class Codeforces_VKCup_2016_round_3_BearAndColors {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int balls = input.nextInt();
        int[] interval = new int[balls];
        int[] slots = new int[balls];
        for (int i = 0; i < interval.length; i++) {
            int current = input.nextInt();
            interval[i] = current;
        }

        for (int i = 0; i < interval.length; i++) {
            for (int j = i + 1; j <= interval.length; j++) {
                    slots[dominant(interval, i , j) - 1]++;
            }
        }
        for(int x : slots) {
            System.out.print(x + " ");
        }
        out.close();
    }

    public static int dominant(int[] array, int start, int end) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            if(!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int bestDominantIndex = array[start];
        for(int x : map.keySet()) {
            if(map.get(x) > map.get(bestDominantIndex)) {
                bestDominantIndex = x;
            } else if(map.get(x).equals(map.get(bestDominantIndex))) {
                if(bestDominantIndex > x) {
                    bestDominantIndex = x;
                }
            }
        }
        return bestDominantIndex;
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