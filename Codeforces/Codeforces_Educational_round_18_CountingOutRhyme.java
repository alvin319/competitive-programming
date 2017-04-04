import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/3/17.
 */

public class Codeforces_Educational_round_18_CountingOutRhyme {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int[] array = new int[k];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int leaderIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int startIndex = (leaderIndex + array[i]) % list.size();
            int value = list.get(startIndex) + 1;
            int nextValue;
            if (startIndex == list.size() - 1) {
                nextValue = list.get(0);
            } else {
                nextValue = list.get(startIndex + 1);
            }
            list.remove(startIndex);
            leaderIndex = list.indexOf(nextValue);
            out.print(i == 0 ? value : " " + value);
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