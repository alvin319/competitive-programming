import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by alvin on 8/11/16.
 */
public class Codeforces_round_366_div_2_Thor {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int p = input.nextInt();
        int q = input.nextInt();
        HashSet<Integer> indexSet = new HashSet<>();
        int currentMessageIndex = 1;
        int totalMessage = 0;
        int threshold = 1;
        HashMap<Integer, Integer>[] messages = new HashMap[p];
        int[] messagePtrs = new int[p];
        int[] readIndexPtrs = new int[p];
        for (int i = 0; i < messagePtrs.length; i++) {
            messagePtrs[i] = 0;
        }
        for (int i = 0; i < readIndexPtrs.length; i++) {
            readIndexPtrs[i] = 0;
        }
        for (int i = 0; i < messages.length; i++) {
            messages[i] = new HashMap<>();
        }
        for (int i = 0; i < q; i++) {
            int type = input.nextInt();
            int app = input.nextInt();
            if (type == 1) {
                totalMessage++;
                messages[app - 1].put(messagePtrs[app - 1], currentMessageIndex);
                messagePtrs[app - 1]++;
                currentMessageIndex++;
            } else if (type == 2) {
                HashMap<Integer, Integer> map = messages[app - 1];
                for (int j = readIndexPtrs[app - 1]; j < map.size(); j++) {
                    indexSet.add(map.get(j));
                }
                readIndexPtrs[app - 1] = map.size();
            } else {
                if (app >= threshold) {
                    for (int j = app; j >= threshold; j--) {
                        indexSet.add(j);
                    }
                    threshold = app;
                }
            }
            out.println(totalMessage - indexSet.size());
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