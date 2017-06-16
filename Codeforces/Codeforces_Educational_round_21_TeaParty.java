import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by WiNDWAY on 7/9/17.
 */

public class Codeforces_Educational_round_21_TeaParty {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        int w = input.nextInt();
        int total = 0;
        int[] array = new int[n];
        TreeSet<Integer> set = new TreeSet<>();
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
            total += Math.ceil(array[i] / 2.00);
            set.add(array[i]);
            if (maxValue < array[i]) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        if (total <= w) {
            int[] answer = new int[n];
            Arrays.fill(answer, - 1);
            int currentAmount = w;
            boolean failed = false;
            for (int i = 0; i < answer.length && currentAmount > 0; i++) {
                int pourAmount = (int)Math.ceil(array[i] / 2.00);
                if (currentAmount >= pourAmount) {
                    currentAmount -= pourAmount;
                    answer[i] = pourAmount;
                    Integer underTea = set.floor(array[i] - 1);
                    if (underTea != null) {
                        int underPour = (int)Math.ceil(underTea / 2.00);
                        if (pourAmount < underPour) {
                            if (currentAmount >= Math.abs(pourAmount - underPour)) {
                                answer[i] += Math.abs(pourAmount - underPour);
                            } else {
                                failed = true;
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            if (currentAmount > 0) {
                Integer[] indexArray = new Integer[answer.length];
                for (int i = 0; i < answer.length; i++) {
                    indexArray[i] = i;
                }
                Arrays.sort(indexArray, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return -new Integer(array[o1]).compareTo(array[o2]);
                    }
                });
                for (int i = 0; i < indexArray.length && currentAmount > 0; i++) {
                    int correctIndex = indexArray[i];
                    int maxTea = array[correctIndex];
                    if (currentAmount > Math.abs(maxTea - answer[correctIndex])) {
                        currentAmount -= Math.abs(maxTea - answer[correctIndex]);
                        answer[correctIndex] = maxTea;
                    } else {
                        if (currentAmount > 0) {
                            answer[correctIndex] += currentAmount;
                            break;
                        }
                    }
                }
            }
            boolean notFilled = false;
            for (int i = 0; i < answer.length; i++) {
                if (answer[i] == -1) {
                    notFilled = true;
                    break;
                }
            }
            if (failed || notFilled) {
                out.println(-1);
            } else {
                for (int i = 0; i < answer.length; i++) {
                    out.print(i == 0 ? answer[i] : " " + answer[i]);
                }
            }
        } else {
            out.println(-1);
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