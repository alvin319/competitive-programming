import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 5/8/2016.
 */

public class Codeforces_Educational_round_6_PearlsInARow {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean repeat = false;
        HashSet<Integer> current = new HashSet<>();
        int startIndex = 0;
        int lastIndex = 0;
        int i = 0;
        for (;i < array.length; i++) {
            if(!current.contains(array[i])) {
                current.add(array[i]);
            } else {
                lastIndex = Math.max(lastIndex, startIndex);
                map.put(startIndex, i);
                repeat = true;
                current.clear();
                startIndex = i + 1;
            }
        }
        if(repeat) {
            if(map.get(lastIndex) != (i - 1)) {
                map.put(lastIndex, i - 1);
            }
            out.println(map.size());
            for (Integer integer : map.keySet()) {
                out.println((integer + 1) + " " + (map.get(integer) + 1));
            }
        } else {
            out.println(-1);
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

