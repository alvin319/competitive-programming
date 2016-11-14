/**
 * Created by qicodeng on 11/21/16.
 */

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Codeforces_Yandex_2011_qualification_2_DoubleCola {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt() - 1;
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Sheldon");
        map.put(1, "Leonard");
        map.put(2, "Penny");
        map.put(3, "Rajesh");
        map.put(4, "Howard");
        int groupSize = 5;
        int currentEndIndex = 5;
        int groupIndex = 1;
        while (n >= currentEndIndex) {
            groupSize *= 2;
            currentEndIndex += groupSize;
            groupIndex *= 2;
        }
        int value = (n - (currentEndIndex - groupSize)) / groupIndex;
        System.out.println(map.get(value));
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
