import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 8/26/2016.
 */

public class Codeforces_round_361_div_2_MikeAndShortcuts {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        Queue<int[]> queue = new LinkedList<>();
        int[] array = new int[input.nextInt()];
        int[] solution = new int[array.length];
        boolean[] visited = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt() - 1;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(1);
        map.put(0, list);
        for (int i = 1; i < array.length - 1; i++) {
            ArrayList<Integer> currentList = map.containsKey(i) ? map.get(i) : new ArrayList<>();
            currentList.add(i + 1);
            currentList.add(i - 1);
            currentList.add(array[i]);
            map.put(i, currentList);
        }
        ArrayList<Integer> lastList = new ArrayList<>();
        lastList.add(array.length - 2);
        lastList.add(array[array.length - 1]);
        map.put(array.length - 1, lastList);
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int index = a[0];
            int sum = a[1];
            if (!visited[index]) {
                visited[index] = true;
                solution[index] = sum;
                for (int x : map.get(index)) {
                    queue.add(new int[]{x, sum + 1});
                }
            }
        }
        for (int i = 0; i < solution.length; i++) {
            System.out.print(i == 0 ? solution[i] : " " + solution[i]);
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