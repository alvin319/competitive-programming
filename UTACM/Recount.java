import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Recount {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            long states = input.nextLong();
            long voters = input.nextLong();
            long k = input.nextLong();
            HashMap<Integer, Integer> election = new HashMap<Integer, Integer>();
            for (int j = 0; j < states; j++) {
                int id = input.nextInt();
                int vote = input.nextInt();
                election.put(id, vote);
            }
            long first = 0;
            long second = 0;
            long electFirst = 0;
            long electSecond = 0;
            for (int j = 0; j < voters; j++) {
                String[] current = input.nextLine().split(" ");
                int win = Integer.parseInt(current[0]);
                if(current[1].equals("SAM")) {
                    first += election.get(win);
                    electFirst++;
                } else {
                    second += election.get(win);
                    electSecond++;
                }
            }
            if(first < k && second < k) {
                if(electFirst == electSecond) {
                    out.println("TIE");
                } else if(electFirst > electSecond) {
                    out.println("SAM");
                } else {
                    out.println("ANJIE");
                }
            } else if(first >= k && second < k) {
                out.println("SAM");
            } else if(second >= k && first < k) {
                out.println("ANJIE");
            } else if(first >= k && second >= k) {
                if(electFirst == electSecond) {
                    out.println("TIE");
                } else if(electFirst > electSecond) {
                    out.println("SAM");
                } else {
                    out.println("ANJIE");
                }
            }

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