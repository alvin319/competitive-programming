import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Alvin on 9/18/2016.
 */

public class Codeforces_round_372_div_2_CompleteTheWord {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        char[] solutionArray = line.toCharArray();
        ArrayList<Character> missing = new ArrayList<>();
        boolean found = false;
        int initialIndex = 0;
        if (line.length() < 26) {
            out.println(-1);
        } else {
            for (int i = 0; i <= line.length() - 26; i++) {
                HashMap<Character, Integer> map = new HashMap<>();
                boolean isCompleted = true;
                for (int j = i; j < i + 26; j++) {
                    char c = line.charAt(j);
                    map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
                    if (map.get(c) > 1 && c != '?') {
                        isCompleted = false;
                        break;
                    }
                }
                if (isCompleted) {
                    int counter = 0;
                    for (char c : map.keySet()) {
                        counter += map.get(c);
                    }
                    if (counter == 26) {
                        for (char k = 'A'; k <= 'Z'; k++) {
                            if (!map.containsKey(k)) {
                                missing.add(k);
                            }
                        }
                        found = true;
                        initialIndex = i;
                        break;
                    }
                }
            }
            if (found) {
                int missingIndex = 0;
                for (int i = initialIndex; i < initialIndex + 26; i++) {
                    if (solutionArray[i] == '?') {
                        solutionArray[i] = missing.get(missingIndex);
                        missingIndex++;
                    }
                }
                StringBuilder current = new StringBuilder();
                for (int i = 0; i < solutionArray.length; i++) {
                    current.append(solutionArray[i] == '?' ? 'A' : solutionArray[i]);
                }
                out.println(current);
            } else {
                out.println(-1);
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



