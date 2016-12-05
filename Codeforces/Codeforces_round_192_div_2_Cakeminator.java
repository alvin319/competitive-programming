/**
 * Created by qicodeng on 12/4/16.
 */

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_round_192_div_2_Cakeminator {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        char[][] matrix = new char[input.nextInt()][input.nextInt()];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
        HashSet<Integer> r = new HashSet<>();
        HashSet<Integer> c = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    r.add(i);
                    c.add(j);
                }
            }
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int answer = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!r.contains(i)) {
                    for (int k = 0; k < matrix[i].length; k++) {
                        if (!visited[i][k]) {
                            visited[i][k] = true;
                            answer++;
                        }
                    }
                    r.add(i);
                } else if (!c.contains(j)) {
                    for (int k = 0; k < matrix.length; k++) {
                        if (!visited[k][j]) {
                            visited[k][j] = true;
                            answer++;
                        }
                    }
                    c.add(j);
                }
            }
        }
        out.println(answer);
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
