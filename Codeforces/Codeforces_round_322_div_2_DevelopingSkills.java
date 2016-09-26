/**
 * Created by qicodeng on 9/30/16.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Codeforces_round_322_div_2_DevelopingSkills {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return new Integer(Math.abs(roundUp(o1) - o1)).compareTo(Math.abs(o2 - roundUp(o2)));
            }
        });
        long answer = 0;
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < list.size(); i++) {
                int current = 10 - (list.get(i) % 10);
                if (list.get(i) == 100) {
                    continue;
                }
                if (k >= current) {
                    list.set(i, list.get(i) + current);
                    k -= current;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            answer += (list.get(i) / 10);
        }
        out.println(answer);
    }

    public static int roundUp(int num) {
        return (10 - num % 10) + num;
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
