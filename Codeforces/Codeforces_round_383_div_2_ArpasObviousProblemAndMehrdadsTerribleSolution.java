import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 12/7/16.
 */

public class Codeforces_round_383_div_2_ArpasObviousProblemAndMehrdadsTerribleSolution {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        int n = input.nextInt();
        int x = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            if (!map.containsKey(array[i])) {
                map.put(array[i], new HashSet<>());
            }
            HashSet<Integer> set = map.get(array[i]);
            set.add(i);
            map.put(array[i], set);
        }
        long answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i] ^ x)) {
                answer += map.get(array[i] ^ x).size();
            }
        }
        out.println(x == 0 ? answer / 2 - (n / 2) : answer / 2);
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