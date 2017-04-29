import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Codeforces_Educational_round_20_DistancesToZero {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int[] array = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            if (array[i] == 0) {
                map.put(i, 1);
            }
        }
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                answer[i] = 0;
            } else {
                Integer left = map.floorKey(i);
                Integer right = map.ceilingKey(i);
                if (left != null) {
                    answer[i] = Math.min(Math.abs(i - left), answer[i]);
                }
                if (right != null) {
                    answer[i] = Math.min(Math.abs(i - right), answer[i]);
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            out.print(i == 0 ? answer[i] : " " + answer[i]);
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