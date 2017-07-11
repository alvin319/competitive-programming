/**
 * Created by alvind on 7/10/17.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Codeforces_round_422_div_2_CrosswordSolving {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        String replace = input.nextLine();
        String original = input.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(original.charAt(i));
        }
        Pair currentPair = change(replace, builder.toString());
        for (int i = n; i < k; i++) {
            builder = builder.deleteCharAt(0);
            builder = builder.append(original.charAt(i));
            Pair newPair = change(replace, builder.toString());
            if (newPair.count < currentPair.count) {
                currentPair = newPair;
            }
        }
        out.println(currentPair.count);
        for (int i = 0; i < currentPair.index.size(); i++) {
            out.print(i == 0 ? currentPair.index.get(i) : " " + currentPair.index.get(i));
        }
        out.close();
    }

    public static Pair change(String replace, String partial) {
        int count = 0;
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < replace.length(); i++) {
            if (replace.charAt(i) != partial.charAt(i)) {
                count++;
                index.add(i + 1);
            }
        }
        return new Pair(count, index);
    }

    static class Pair {
        int count;
        ArrayList<Integer> index = new ArrayList<>();

        public Pair(int c, ArrayList<Integer> l) {
            count = c;
            index = l;
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