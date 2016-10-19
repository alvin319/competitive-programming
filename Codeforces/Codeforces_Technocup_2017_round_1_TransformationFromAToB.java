/**
 * Created by qicodeng on 10/23/16.
 */

import java.io.*;
import java.util.*;

public class Codeforces_Technocup_2017_round_1_TransformationFromAToB {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long a = input.nextLong();
        long b = input.nextLong();
        HashSet<Long> seen = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        ArrayList<Long> init = new ArrayList<>();
        init.add(a);
        State current = new State(a);
        current.path = init;
        q.add(new State(a));
        boolean lmao = false;
        while (!q.isEmpty()) {
            State now = q.poll();
            if (!seen.contains(now.current)) {
                seen.add(now.current);
                long next1 = now.current * 2;
                long next2 = now.current * 10 + 1;
                if (next1 == b || next2 == b) {
                    lmao = true;
                    out.println("YES");
                    out.println(now.path.size() + 2);
                    String answer = "" + a;
                    for (int i = 0; i < now.path.size(); i++) {
                        answer += " " + now.path.get(i);
                    }
                    answer += " " + b;
                    out.println(answer);
                    break;
                } else {
                    if (next1 < b) {
                        ArrayList<Long> newL = new ArrayList<>();
                        for (int i = 0; i < now.path.size(); i++) {
                            newL.add(now.path.get(i));
                        }
                        newL.add(next1);
                        State future = new State(next1);
                        future.path = newL;
                        q.add(future);
                    }
                    if (next2 < b) {
                        ArrayList<Long> newL = new ArrayList<>();
                        for (int i = 0; i < now.path.size(); i++) {
                            newL.add(now.path.get(i));
                        }
                        newL.add(next2);
                        State future = new State(next2);
                        future.path = newL;
                        q.add(future);
                    }
                }
            }
        }
        if (!lmao) {
            out.println("NO");
        }
        out.close();
    }

    static class State {
        long current;
        ArrayList<Long> path;

        public State(long current) {
            this.current = current;
            path = new ArrayList<>();
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
