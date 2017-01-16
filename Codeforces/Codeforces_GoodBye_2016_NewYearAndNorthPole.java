import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 1/15/2017.
 */

public class Codeforces_GoodBye_2016_NewYearAndNorthPole {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        int distance = 0;
        boolean correct = true;
        for (int i = 0; i < count; i++) {
            String[] info = input.nextLine().split(" ");
            int length = Integer.parseInt(info[0]);
            String direction = info[1];
            if (distance == 0) {
                if (direction.equals("South")) {
                    distance += length;
                    if (distance > 20000) {
                        correct = false;
                    }
                } else correct = false;
            } else if (distance == 20000) {
                if (direction.equals("North")) {
                    distance -= length;
                    if (distance < 0) {
                        correct = false;
                    }
                } else correct = false;
            } else {
                if (direction.equals("South")) {
                    distance += length;
                    if (distance > 20000) {
                        correct = false;
                    }
                } else if (direction.equals("North")) {
                    distance -= length;
                    if (distance < 0) {
                        correct = false;
                    }
                }
            }
        }
        if (distance != 0) {
            correct = false;
        }
        if (correct) {
            out.println("YES");
        } else {
            out.println("NO");
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

