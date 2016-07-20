import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by alvin on 7/19/16.
 */
public class Codeforces_round_363_div_2_OneBomb {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int r = input.nextInt();
        int c = input.nextInt();
        char[][] matrix = new char[r][c];
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();
        int starCount = 0;
        for (int i = 0; i < r; i++) {
            char[] array = input.nextLine().toCharArray();
            int currentCount = 0;
            for (int j = 0; j < array.length; j++) {
                matrix[i][j] = array[j];
                if (array[j] == '*') {
                    starCount++;
                    currentCount++;
                }
            }
            rowMap.put(i, currentCount);
        }

        for (int i = 0; i < c; i++) {
            int currentCount = 0;
            for (int j = 0; j < r; j++) {
                if(matrix[j][i] == '*') {
                    currentCount++;
                }
            }
            colMap.put(i, currentCount);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int totalCount = rowMap.get(i) + colMap.get(j);
                totalCount -= matrix[i][j] == '*' ? 1 : 0;
                if(totalCount == starCount) {
                    out.println("YES");
                    out.println((i + 1) + " " + (j + 1));
                    System.exit(0);
                }
            }
        }
        out.println("NO");
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
