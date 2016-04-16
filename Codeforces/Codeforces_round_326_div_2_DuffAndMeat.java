import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 4/16/16.
 */

public class Codeforces_round_326_div_2_DuffAndMeat {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        Day[] list = new Day[count];
        LinkedList<Integer> index = new LinkedList<Integer>();
        for (int i = 0; i < count; i++) {
            list[i] = new Day(i, input.nextInt(), input.nextInt());
        }
        Day[] preSort = list.clone();
        Arrays.sort(list, new Comparator<Day>() {
            @Override
            public int compare(Day o1, Day o2) {
                return new Integer(o1.cost).compareTo(o2.cost);
            }
        });
        index.addFirst(list[0].day);
        int previousDay = list[0].day;
        for (int i = 1; i < list.length; i++) {
            if(list[i].day < previousDay) {
                previousDay = list[i].day;
                index.addFirst(previousDay);
            }
        }
        Collections.sort(index);
        long totalSum = 0;
        for (int i = 1; i < index.size(); i++) {
            int pIndex = index.get(i - 1);
            int currentNeed = 0;
            for (int j = pIndex; j < index.get(i); j++) {
                currentNeed += preSort[j].need;
            }
            totalSum += currentNeed * preSort[pIndex].cost;
        }
        int lastNeed = 0;
        for (int i = index.get(index.size() - 1); i < list.length; i++) {
            lastNeed += preSort[i].need;
        }
        out.println(totalSum + lastNeed * preSort[index.get(index.size() - 1)].cost);

        out.close();
    }

    public static class Day {
        int day;
        int need;
        int cost;

        public Day(int day, int need, int cost) {
            this.day = day;
            this.need = need;
            this.cost = cost;
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