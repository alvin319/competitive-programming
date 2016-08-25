import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 8/24/2016.
 */

public class Codeforces_round_284_div_2_Lecture {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] array = input.nextLine().split(" ");
            map.put(array[0], array[1]);
        }
        String[] array = input.nextLine().split(" ");
        String[] solution = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String current = array[i];
            String next = map.get(current);
            if (next.length() < current.length()) {
                solution[i] = next;
            } else {
                solution[i] = current;
            }
        }
        for (int i = 0; i < solution.length; i++) {
            out.print(i == 0 ? solution[i] : " " + solution[i]);
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

