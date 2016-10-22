/**
 * Created by qicodeng on 10/23/16.
 */

import java.io.*;
import java.util.*;

public class Codeforces_ICPC_SouthernSubRegional_Lottery {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int a = input.nextInt();
        int b = input.nextInt();
        int[] array = new int[a];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
        }
        int even = a / b;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= b; i++) {
            if (!map.containsKey(i) || map.get(i) < even) {
                set.add(i);
            }
        }
        int answer = 0;
        for (int i : set) {
            answer += map.containsKey(i) ? Math.abs(map.get(i) - even) : even;
        }
        out.println(answer);
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
