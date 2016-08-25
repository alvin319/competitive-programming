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
        HashMap<String, String> firstLang = new HashMap<>();
        HashMap<String, String> secondLang = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] array = input.nextLine().split(" ");
            firstLang.put(array[0], array[1]);
            secondLang.put(array[1], array[0]);
        }
        String[] array = input.nextLine().split(" ");
        String[] solution = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            String current = array[i];
            // Second Found
            String first = firstLang.get(current);
            // First Found
            String second = secondLang.get(current);
            if (first == null) {
                if (current.length() > second.length()) {
                    solution[i] = second;
                } else if (current.length() == second.length()) {
                    solution[i] = second;
                }
            } else if (second == null) {
                if (current.length() > first.length()) {
                    solution[i] = first;
                } else if (current.length() == first.length()) {
                    solution[i] = current;
                }
            }
        }
        System.out.println(Arrays.toString(solution));
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

