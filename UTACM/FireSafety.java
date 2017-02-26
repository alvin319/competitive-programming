import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FireSafety {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int s = input.nextInt();
        long t = input.nextLong();
        long original = t;
        ArrayList<State> stairList = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            stairList.add(new State(i, input.nextInt()));
        }
        Collections.sort(stairList, new Comparator<State>() {
            @Override
            public int compare(State o1, State o2) {
                return new Integer(o1.congestion).compareTo(o2.congestion);
            }
        });
        long[] answer = new long[stairList.size()];
        long answerTotal = 0;
        for (int i = 0; i < stairList.size(); i++) {
            long people = t / stairList.get(i).congestion;
            answer[stairList.get(i).index] += people;
            answerTotal += people;
        }
        out.println(answerTotal);
        for (int i = 0; i < answer.length; i++) {
            out.print(i == 0 ? answer[i] : " " + answer[i]);
        }

        out.close();
    }

    static class State {
        int index;
        int congestion;

        public State (int i, int s) {
            index = i;
            congestion = s;
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