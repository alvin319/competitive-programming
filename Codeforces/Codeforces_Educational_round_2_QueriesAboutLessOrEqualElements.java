import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 9/20/2016.
 */

public class Codeforces_Educational_round_2_QueriesAboutLessOrEqualElements {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] second = new int[input.nextInt()];
        for (int i = 0; i < count; i++) {
            list.add(input.nextInt());
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = input.nextInt();
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (int i = 0; i < second.length; i++) {
            int closeValue = map.floorKey(second[i]) == null ? -1 : map.floorKey(second[i]);
            int answer = closeValue == -1 ? -1 : map.get(map.floorKey(second[i]));
            out.print(i == 0 ? answer + 1 : " " + (answer + 1));
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

