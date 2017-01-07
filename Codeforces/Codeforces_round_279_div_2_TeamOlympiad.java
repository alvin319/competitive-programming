import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/10/2017.
 */

public class Codeforces_round_279_div_2_TeamOlympiad {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int[] array = new int[input.nextInt()];
        Queue<Integer> m = new LinkedList<>();
        Queue<Integer> p = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            switch (array[i]) {
                case 1 : {
                    c.add(i + 1);
                } break;
                case 2 : {
                    m.add(i + 1);
                } break;
                default : {
                    p.add(i + 1);
                }
            }
        }
        int answer = Math.min(m.size(), Math.min(p.size(), c.size()));
        out.println(answer);
        for (int i = 0; i < answer; i++) {
            out.println(m.poll() + " " + p.poll() + " " + c.poll());
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

