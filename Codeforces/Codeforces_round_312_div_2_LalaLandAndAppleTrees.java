import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class Codeforces_round_312_div_2_LalaLandAndAppleTrees {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int size = input.nextInt();
        int pos = 0;
        int neg = 0;
        long summation = 0;
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            int c = input.nextInt();
            pos += c > 0 ? 1 : 0;
            neg += c < 0 ? 1 : 0;
            int absC = Math.abs(c);
            int apple = input.nextInt();
            if (c > 0) {
                right.put(absC, apple);
            } else {
                left.put(absC, apple);
            }
            summation += apple;
        }
        long sum = 0;
        if (pos == neg) {
            System.out.println(summation);
        } else {
            if (pos > neg) {
                long i = 1;
                for (int x : left.keySet()) {
                    if (i <= neg) {
                        sum += left.get(x);
                    } else {
                        break;
                    }
                    i++;
                }
                i = 1;
                for (int x : right.keySet()) {
                    if (i <= neg + 1) {
                        sum += right.get(x);
                    } else {
                        break;
                    }
                    i++;
                }
            } else {
                long i = 1;
                for (int x : right.keySet()) {
                    if (i <= pos) {
                        sum += right.get(x);
                    } else {
                        break;
                    }
                    i++;
                }
                i = 1;
                for (int x : left.keySet()) {
                    if (i <= pos + 1) {
                        sum += left.get(x);
                    } else {
                        break;
                    }
                    i++;
                }
            }
            out.println(sum);
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