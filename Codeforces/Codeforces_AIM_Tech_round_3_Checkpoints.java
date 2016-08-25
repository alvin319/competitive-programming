import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 8/24/2016.
 */

public class Codeforces_AIM_Tech_round_3_Checkpoints {

    static int current;
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        current = input.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer o1D = Math.abs(o1 - current);
                Integer o2D = Math.abs(o2 - current);
                return o1D.compareTo(o2D);
            }
        });
        int answer = 0;
        for (int i = 1; i <= (n - 1); i++) {
            int first = list.removeFirst();
            int result = Math.abs(current - first);
            System.out.println(first + " " + result + " " + answer);
            answer += result;
            current = first;
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    Integer o1D = Math.abs(o1 - current);
                    Integer o2D = Math.abs(o2 - current);
                    return o1D.compareTo(o2D);
                }
            });
        }
        out.println(answer);
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

