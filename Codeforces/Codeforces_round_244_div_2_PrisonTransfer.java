import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Codeforces_round_244_div_2_PrisonTransfer {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int t = input.nextInt();
        int c = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < c; i++) {
            int num = array[i];
            list.addLast(array[i]);
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        if (map.floorKey(Integer.MAX_VALUE) != null && map.floorKey(Integer.MAX_VALUE) <= t) {
            answer++;
        }
        for (int i = c; i < n; i++) {
            int removeNum = list.removeFirst();
            if (map.get(removeNum) == 1) {
                map.remove(removeNum);
            } else {
                map.put(removeNum, map.get(removeNum) - 1);
            }
            list.addLast(array[i]);
            map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);
            if (map.floorKey(Integer.MAX_VALUE) != null && map.floorKey(Integer.MAX_VALUE) <= t) {
                answer++;
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