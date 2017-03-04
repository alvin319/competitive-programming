import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_402_div_2_DishonestSellers {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];
        for (int i = 0; i < first.length; i++) {
            first[i] = input.nextInt();
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = input.nextInt();
        }
        Diff[] result = new Diff[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Diff(i, first[i] - second[i]);
        }
        Arrays.sort(result, new Comparator<Diff>() {
            @Override
            public int compare(Diff o1, Diff o2) {
                return new Integer(o1.diff).compareTo(o2.diff);
            }
        });
        int answer = 0;
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (Diff current : result) {
            if (count != k) {
                answer += first[current.index];
                set.add(current.index);
                count++;
            } else if (current.diff < 0) {
                answer += first[current.index];
                set.add(current.index);
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (!set.contains(i)) {
                answer += second[i];
            }
        }
        out.println(answer);
        out.close();
    }

    static class Diff {
        int index;
        int diff;

        public Diff(int i, int d) {
            index = i;
            diff = d;
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