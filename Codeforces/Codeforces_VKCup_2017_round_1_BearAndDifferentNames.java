import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Codeforces_VKCup_2017_round_1_BearAndDifferentNames {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int k = input.nextInt();
        String[] answer = new String[n];
        String[] result = input.nextLine().split(" ");
        String[] possibleString = new String[50];
        char start = 'A';
        char lowStart = 'a';
        int nextPart = 26;
        HashMap<String, Integer> charMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            possibleString[i] = (char) ((int) start + i) + "";
            charMap.put(possibleString[i], i);
            if (nextPart + i < 50) {
                possibleString[nextPart + i] = "A" + (char) ((int) lowStart + i);
                charMap.put(possibleString[nextPart + i], nextPart + i);
            }
        }
        if (result[0].equals("NO")) {
            answer[0] = "A";
            answer[k - 1] = "A";
            for (int i = 1; i < k - 1; i++) {
                answer[i] = possibleString[charMap.get(answer[i - 1]) + 1];
            }
        } else {
            for (int i = 0; i < k; i++) {
                answer[i] = possibleString[i];
            }
        }
        for (int i = 1; i < result.length; i++) {
            switch (result[i]) {
                case "YES": {
                    HashSet<String> set = new HashSet<>();
                    for (int j = i; j < i + k - 1; j++) {
                        set.add(answer[j]);
                    }
                    for (String key : charMap.keySet()) {
                        if (!set.contains(key)) {
                            answer[i + k - 1] = key;
                            break;
                        }
                    }
                }
                break;
                default: {
                    answer[i + k - 1] = answer[i];
                }
            }
        }
        for (int i = 0; i < answer.length; i++) {
            out.print(i == 0 ? answer[i] : " " + answer[i]);
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