import java.io.*;
import java.util.*;

public class Codeforces_round_292_div_2_DrazilAndFactorial {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        String line = input.nextLine();
        ArrayList<Integer> total = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                index++;
            } else {
                break;
            }
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(4, new int[]{2, 2, 3});
        map.put(6, new int[]{3, 5});
        map.put(8, new int[]{2, 2, 2, 7});
        map.put(9, new int[]{3, 3, 2, 7});
        for (int i = index; i < line.length(); i++) {
            int num = line.charAt(i) - '0';
            if (!map.containsKey(num) && num != 1 && num != 0) {
                total.add(num);
            } else if (map.containsKey(num)) {
                for (int j = 0; j < map.get(num).length; j++) {
                    total.add(map.get(num)[j]);
                }
            }
        }
        Collections.sort(total);
        for (int i = total.size() - 1; i >= 0; i--) {
            out.print(total.get(i));
        }
        out.close();
    }

    public static ArrayList<Integer> primeFactors(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        while (number % 2 == 0) {
            list.add(2);
            number /= 2;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                list.add(i);
                number /= i;
            }
        }

        if (number > 2) {
            list.add(number);
        }

        return list;
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