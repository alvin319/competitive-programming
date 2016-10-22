import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 10/21/2016.
 */

public class Codeforces_round_375_div_2_LakesInBerland {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int m = input.nextInt();
        int target = input.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < mat.length; i++) {
            mat[i] = input.nextLine().toCharArray();
        }
        boolean[][] check = new boolean[n][m];
        int[][] islandM = new int[n][m];
        Queue<Info> q = new LinkedList<>();
        HashSet<Integer> ocean = new HashSet<>();
        int[] dX = new int[]{0, 0, -1, 1};
        int[] dY = new int[]{1, -1, 0, 0};
        int islandCount = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char current = mat[i][j];
                if (current == '.' && !check[i][j]) {
                    q.add(new Info(i, j, current, islandCount));
                    while (!q.isEmpty()) {
                        Info k = q.poll();
                        if (!check[k.x][k.y] && mat[k.x][k.y] == '.') {
                            check[k.x][k.y] = true;
                            islandM[k.x][k.y] = k.island;
                            for (int l = 0; l < dX.length; l++) {
                                int newX = k.x + dX[l];
                                int newY = k.y + dY[l];
                                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                                    q.add(new Info(newX, newY, mat[newX][newY], k.island));
                                }
                            }
                        }
                    }
                    islandCount++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (islandM[i][j] != 0 && (i == 0 || i == n - 1 || j == 0 || j == m - 1)) {
                    ocean.add(islandM[i][j]);
                }
            }
        }
        check = new boolean[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (islandM[i][j] != 0 && !ocean.contains(islandM[i][j]) && !check[i][j]) {
                    check[i][j] = true;
                    map.put(islandM[i][j], map.containsKey(islandM[i][j]) ? map.get(islandM[i][j]) + 1 : 1);
                }
            }
        }
        int lakesRemove = map.keySet().size() - target;
        ArrayList<Integer> lakeList = new ArrayList<>(map.keySet());
        Collections.sort(lakeList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        HashSet<Integer> removedSet = new HashSet<>();
        for (int i = 0; i < lakesRemove; i++) {
            removedSet.add(lakeList.get(i));
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (removedSet.contains(islandM[i][j])) {
                    answer++;
                    mat[i][j] = '*';
                }
            }
        }
        out.println(answer);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(mat[i][j]);
            }
            out.println();
        }
        out.close();
    }


    static class Info {
        int x;
        int y;
        char t;
        int island;

        public Info(int x, int y, char t, int island) {
            this.x = x;
            this.y = y;
            this.t = t;
            this.island = island;
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

