import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 10/7/16.
 */

public class MissingNumbers {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashSet<Long> missing = new HashSet<>();
        HashMap<Long, Long> fMap = new HashMap<>();
        HashMap<Long, Long> sMap = new HashMap<>();
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            long c = input.nextLong();
            fMap.put(c, fMap.containsKey(c) ? fMap.get(c) + 1 : 1);
        }
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            long c = input.nextLong();
            sMap.put(c, sMap.containsKey(c) ? sMap.get(c) + 1 : 1);
        }
        for (long x : fMap.keySet()) {
            if (!fMap.get(x).equals(sMap.get(x)) || !sMap.containsKey(x)) {
                missing.add(x);
            }
        }
        ArrayList<Long> l = new ArrayList<>();
        for (long x : missing) {
            l.add(x);
        }
        Collections.sort(l);
        String s = "";
        for (int i = 0; i < l.size(); i++) {
            s += i == 0 ? l.get(i) : " " + l.get(i);
        }
        System.out.println(s);
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