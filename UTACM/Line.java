import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Line {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        long count = input.nextLong();
        for (int i = 0; i < count; i++) {
            long p = input.nextLong();
            long b = input.nextLong();
            String permu = "";
            for (int j = 0; j < p; j++) {
                long voter = input.nextLong();
                for (int k = 0; k < voter; k++) {
                    permu += (char)((int)'A' + j);
                }
            }
            ArrayList<Character> currentPermu = new ArrayList<>();
            for(Character x : permu.toCharArray()) {
                currentPermu.add(x);
            }
            ArrayList<String> rules = new ArrayList<>();
            for (int j = 0; j < b; j++) {
                String newRule = input.nextLine().replace('*', '.');
                newRule = ".*" + newRule + ".*";
                rules.add(newRule);
            }
            ArrayList<String> solution = new ArrayList<>();
            getPermutation(solution, currentPermu, rules, "");
            if(solution.isEmpty()) {
                System.out.println("FIGHT");
            } else {
                Collections.sort(solution);
                for (String x : solution) {
                    System.out.println(x);
                }
            }
            System.out.println();
        }
        out.close();
    }

    public static void getPermutation(ArrayList<String> set, ArrayList<Character> current, ArrayList<String> rules, String prefix) {
        if(current.size() == 0) {
            boolean valid = true;
            for (String x : rules) {
                Pattern r = Pattern.compile(x);
                if (r.matcher(prefix).matches()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if(!set.contains(prefix)) {
                    set.add(prefix);
                }
            }
        } else {
            for (int i = 0; i < current.size(); i++) {
                String newString = prefix + current.get(i);
                ArrayList<Character> newSet = new ArrayList<>(current);
                newSet.remove(i);
                getPermutation(set, newSet, rules, newString);
            }
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