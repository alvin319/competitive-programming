import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by alvindeng on 5/18/17.
 */
public class Codeforces_Educational_round_21_AverageSleepTime {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int week = n - k + 1;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        long answer = 0;
        long total = 0;

        for (int i = 0; i < array.length; i++) {
            if (list.size() < k) {
                list.add(array[i]);
                total += array[i];
            } else {
                answer += total;
                list.add(array[i]);
                total += array[i];
                total -= list.removeFirst();
            }
        }
        answer += total;
        out.println(answer / (double) week);
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
