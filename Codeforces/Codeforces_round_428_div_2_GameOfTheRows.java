import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Codeforces_round_428_div_2_GameOfTheRows {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] info = new int[k];
        long total = 0;
        for (int i = 0; i < k; i++) {
            info[i] = input.nextInt();
            total += info[i];
        }
        int[][] seats = new int[n][8];
        for (int i = 0; i < seats.length; i++) {
            Arrays.fill(seats[i], -1);
        }
        int groupIndex = 0;
        int rowIndex = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(7);
        long answer = 0;
        while (groupIndex < info.length) {
            int seatIndex = 0;
            while (rowIndex < seats.length && seatIndex < seats[rowIndex].length && groupIndex < info.length) {
                if (info[groupIndex] > 0) {
                    if (set.contains(seatIndex)) {
                        if (seats[rowIndex][seatIndex - 1] == groupIndex) {
                            seats[rowIndex][seatIndex] = groupIndex;
                            info[groupIndex]--;
                            answer++;
                        }
                    } else {
                        seats[rowIndex][seatIndex] = groupIndex;
                        info[groupIndex]--;
                        answer++;
                    }
                    seatIndex++;
                } else {
                    groupIndex++;
                }
            }
            rowIndex++;
        }
        out.println(answer == total ? "YES" : "NO");
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