/**
 * Created by qicodeng on 11/7/16.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Codeforces_round_109_div_2_Combination {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        Pair[] array = new Pair[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Pair(input.nextInt(), input.nextInt());
        }
        Arrays.sort(array, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int result = -1 * new Integer(o1.y).compareTo(o2.y);
                return result == 0 ? -1 * new Integer(o1.x).compareTo(o2.x) : result;
            }
        });
        int total = 0;
        total += array[0].x;
        int cont = array[0].y;
        int index = 1;
        while (cont > 0 && index < array.length) {
            total += array[index].x;
            cont = cont - 1 + array[index].y;
            index++;
        }
        out.println(total);
        out.close();
    }

    static class Pair {
        int x;
        int y;

        public Pair(int a, int b) {
            x = a;
            y = b;
        }

        public String toString() {
            return x +  " " + y;
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
