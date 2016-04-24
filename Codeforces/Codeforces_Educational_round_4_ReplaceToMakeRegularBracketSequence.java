import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 4/24/2016.
 */

public class Codeforces_Educational_round_4_ReplaceToMakeRegularBracketSequence {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        String line = input.nextLine();
        Stack<Character> stack = new Stack<Character>();
        Character[] o = {'[', '(', '{', '<'};
        Character[] c = {']', ')', '}', '>'};
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < o.length; i++) {
            map.put(o[i], c[i]);
        }
        HashSet<Character> open = new HashSet<>(Arrays.asList(o));
        HashSet<Character> close = new HashSet<>(Arrays.asList(c));
        int answer = 0;
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if(open.contains(current)) {
                stack.push(current);
            } else {
                if(!stack.isEmpty()) {
                    char peeking = stack.peek();
                    if (close.contains(peeking)) {
                        out.println("Impossible");
                        System.exit(0);
                    } else {
                        if (map.get(peeking) != current) {
                            answer++;
                        }
                        stack.pop();
                    }
                } else {
                    stack.push(current);
                }
            }
        }
        if(!stack.isEmpty()) {
            out.println("Impossible");
        } else {
            out.println(answer);
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

