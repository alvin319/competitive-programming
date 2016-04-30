import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class PowerGrid {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            int commands = input.nextInt();
            int[][] matrix = new int[r][c];
            for (int j = 0; j < matrix.length; j++) {
                char[] convert = input.nextLine().toCharArray();
                for (int k = 0; k < convert.length; k++) {
                    matrix[j][k] = convert[k] - '0';
                }
            }
            for (int j = 0; j < commands; j++) {
                String[] com = input.nextLine().split(" ");
                if (com[0].equals("R")) {
                    int switchC = Integer.parseInt(com[1]);
                    for (int k = 0; k < matrix.length; k++) {
                        for (int l = 0; l < matrix[k].length; l++) {
                            if(k % switchC == 0) {
                                matrix[k][l] = matrix[k][l] == 0 ? 1 : 0;
                            }
                        }
                    }
                } else {
                    int switchC = Integer.parseInt(com[1]);
                    for (int k = 0; k < matrix.length; k++) {
                        for (int l = 0; l < matrix[k].length; l++) {
                            if(l % switchC == 0) {
                                matrix[k][l] = matrix[k][l] == 0 ? 1 : 0;
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    out.print(matrix[j][k]);
                }
                out.println();
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