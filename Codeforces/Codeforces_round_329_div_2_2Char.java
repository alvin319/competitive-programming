import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 5/3/16.
 */

public class Codeforces_round_329_div_2_2Char {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int size = input.nextInt();
        Map<String, Integer> data = new TreeMap<String, Integer>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < size; ++i){
            char[] s = input.next().toCharArray();
            String result = "";
            for (int j = 0; j < s.length; ++j){
                if (!result.contains(Character.toString(s[j]))) result += s[j];
            }
            if (result.length() < 3) {
                if (data.containsKey(result)) data.put(result, data.get(result) + s.length);
                else data.put(result, s.length);
            }
        }
        int max = 0;
        for (int i = 0; i < 26; ++i){
            for (int j = i; j < 26; ++j){
                int temp = 0;
                for (String s : data.keySet()){
                    if (s.equals(String.valueOf(alphabet.charAt(i)) + String.valueOf(alphabet.charAt(j))) ||
                            s.equals(String.valueOf(alphabet.charAt(j)) + String.valueOf(alphabet.charAt(i))) ||
                            s.equals(String.valueOf(alphabet.charAt(i))) ||
                            s.equals(String.valueOf(alphabet.charAt(j)))){
                        temp += data.get(s);
                    }
                }
                max = Math.max(temp, max);
            }
        }
        out.println(max);
        out.close();
    }


    public static PrintWriter out;

    public static class Article {
        HashMap<Character, Integer> map;

        public Article(String current) {
            map = new HashMap<>();
            for (int j = 0; j < current.length(); j++) {
                if (!map.containsKey(current.charAt(j))) {
                    map.put(current.charAt(j), 1);
                } else {
                    map.put(current.charAt(j), map.get(current.charAt(j)) + 1);

                }
            }
        }
    }

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