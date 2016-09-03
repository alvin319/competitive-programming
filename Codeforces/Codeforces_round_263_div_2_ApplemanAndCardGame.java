import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by WiNDWAY on 9/3/16.
 */

public class Codeforces_round_263_div_2_ApplemanAndCardGame {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        long cards = input.nextLong();
        String current = input.nextLine();
        HashMap<Character, Long> map = new HashMap<>();
        for (int i = 0; i < current.length(); i++) {
            char currentChar = current.charAt(i);
            map.put(currentChar, map.containsKey(currentChar) ? map.get(currentChar) + 1 : 1);
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return -1 * map.get(o1).compareTo(map.get(o2));
            }
        });
        BigInteger answer = BigInteger.ZERO;
        for (char x : list) {
            if (map.get(x) >= cards) {
                answer = answer.add(BigInteger.valueOf(cards).multiply(BigInteger.valueOf(cards)));
                break;
            } else {
                answer = answer.add(BigInteger.valueOf(map.get(x)).multiply(BigInteger.valueOf(map.get(x))));
                cards -= map.get(x);
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