import java.io.*;
import java.util.*;

public class Chat {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int count = input.nextInt();
            HashMap<String, Long> marker = new HashMap<>();
            PriorityQueue<State> queue = new PriorityQueue<State>(new Comparator<State>() {
                @Override
                public int compare(State o1, State o2) {
                    return -1 * new Long(o1.index).compareTo(o2.index);
                }
            });
            long iter = 0;
            for (int j = 0; j < count; j++) {
                String[] info = input.nextLine().split(" ");
                switch (info[0]) {
                    case "SEND": {
                        queue.add(new State(info[1], iter));
                        if (!marker.containsKey(info[1])) {
                            marker.put(info[1], iter);
                        }
                        iter++;
                    } break;
                    case "RECEIVE" :{
                        queue.add(new State(info[1], iter));
                        if (!marker.containsKey(info[1])) {
                            marker.put(info[1], iter);
                        }
                        iter++;
                    } break;
                    case "DELETE": {
                        boolean printed = false;
                        while (!queue.isEmpty()) {
                            State currentState = queue.poll();
                            long iterValue = currentState.index;
                            if (marker.containsKey(currentState.person) && iterValue >= marker.get(currentState.person)) {
                                out.println(currentState.person);
                                marker.remove(currentState.person);
                                printed = true;
                                break;
                            }
                        }
                        if (queue.isEmpty() && !printed) {
                            out.println("NONE");
                        }
                    } break;
                }
            }
            System.out.println();
        }
        out.close();
    }

    static class State {
        String person;
        long index;

        public State(String s, long i) {
            person = s;
            index = i;
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