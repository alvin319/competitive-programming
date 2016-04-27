import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/27/16.
 */

public class Codeforces_round_304_div_2_SoldierAndCards {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int cards = input.nextInt();
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();
        int firstC = input.nextInt();
        for (int i = 0; i < firstC; i++) {
            first.addLast(input.nextInt());
        }
        int secondC = input.nextInt();
        for (int i = 0; i < secondC; i++) {
            second.addLast(input.nextInt());
        }
        HashSet<LinkedList<Integer>> firstAppearance = new HashSet<>();
        firstAppearance.add(first);
        HashSet<LinkedList<Integer>> secondAppearance = new HashSet<>();
        secondAppearance.add(second);

        int moves = 0;
        while(!first.isEmpty() && !second.isEmpty()) {
            int firstTop = first.removeFirst();
            int secondTop = second.removeFirst();
            if(firstTop > secondTop) {
                first.addLast(secondTop);
                first.addLast(firstTop);
            } else {
                second.addLast(firstTop);
                second.addLast(secondTop);
            }
            if(firstAppearance.contains(first) && secondAppearance.contains(second)) {
                System.out.println(-1);
                System.exit(0);
            }
            firstAppearance.add(first);
            secondAppearance.add(second);
            moves++;
        }
        if(first.isEmpty()) {
            System.out.println(moves + " " + 2);
        } else {
            System.out.println(moves +  " " + 1);
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