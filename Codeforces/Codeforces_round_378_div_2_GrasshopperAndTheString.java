import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 11/2/16.
 */

public class Codeforces_round_378_div_2_GrasshopperAndTheString {

    public static HashSet<Integer> set;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[] array = input.nextLine().toLowerCase().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u' || array[i] == 'y') {
                set.add(i);
            }
        }
        int answer = 1;
        int previous = -1;
        int current = findNext(array, 0);
        if (current == -1) {
            out.println(array.length + 1);
        } else {
            while (current != -1) {
                answer = Math.max(answer, current - previous);
                previous = current;
                current = findNext(array, current + 1);
            }
            out.println(Math.max(answer, array.length - previous));
        }
        out.close();
    }

    public static int findNext(char[] array, int current) {
        for (int i = current; i < array.length; i++) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
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