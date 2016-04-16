import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Codeforces_round_334_div_2_MoreCowbell {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] cowbells = new int[input.nextInt()];
        int boxes = input.nextInt();
        int highest = -1;
        for (int i = 0; i < cowbells.length; i++) {
            cowbells[i] = input.nextInt();
            highest = Math.max(highest, cowbells[i]);
        }
        int start = 0;
        int end = 2 * (cowbells.length - boxes) - 1;
        while (end > start) {
            int startVal = cowbells[start];
            int endVal = cowbells[end];
            highest = Math.max(highest, startVal + endVal);
            start++;
            end--;
        }
        out.println(highest);
        out.close();
    }

    public static int binarySearch(int[] array, int value, int low, int high) {
        if(low >= high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if(array[mid] == value) {
            return mid;
        }
        return array[mid] > value ? binarySearch(array, value, 0, mid) : mid;
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