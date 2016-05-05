import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 5/4/16.
 */

public class Codeforces_Educational_round_5_TheLabyrinth {


    static char[][] matrix;
    static boolean[][] visited;
    static int[][] compCount;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        n = input.nextInt();
        m = input.nextInt();
        matrix = new char[n][m];
        visited = new boolean[n][m];
        compCount = new int[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                compCount[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        int componentCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && matrix[i][j] == '.') {
                    queue.add(new int[]{i, j});
                    int currentCount = 0;
                    while(!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int r = current[0];
                        int c = current[1];
                        if(!visited[r][c]) {
                            visited[r][c] = true;
                            if (matrix[r][c] == '.') {
                                compCount[r][c] = componentCount;
                                currentCount++;
                            }
                            for (int k = 0; k < dx.length; k++) {
                                int newI = r + dx[k];
                                int newJ = c + dy[k];
                                if (!(Math.min(newI, newJ) < 0 || newI >= n || newJ >= m)) {
                                    if(matrix[newI][newJ] == '.') {
                                        queue.add(new int[]{newI, newJ});
                                    }
                                }
                            }
                        }
                    }
                    map.put(componentCount, currentCount);
                    componentCount++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == '*') {
                    HashSet<Integer> comp = new HashSet<>();
                    for (int k = 0; k < dx.length; k++) {
                        int newI = i + dx[k];
                        int newJ = j + dy[k];
                        if(!(Math.min(newI, newJ) < 0 || newI >= n || newJ >= m)) {
                            if(matrix[newI][newJ] != '*') {
                                    comp.add(compCount[newI][newJ]);
                            }
                        }
                    }
                    int total = 1;
                    for(int x : comp) {
                        if(map.containsKey(x)) {
                            total += map.get(x);
                        }
                    }
                    total %= 10;
                    matrix[i][j] = (char)(total + (int)'0');
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(matrix[i][j]);
            }
            out.println();
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