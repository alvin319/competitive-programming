import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 9/24/16.
 */

public class Sorting {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            String[] array = new String[input.nextInt()];
            for (int j = 0; j < array.length; j++) {
                array[j] = input.nextLine();
            }
            List<String> list = new ArrayList<>();
            for (int j = 0; j < array.length; j++) {
                list.add(array[j]);
            }
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] first = o1.split(" ");
                    String[] second = o2.split(" ");
                    int compare = first[1].compareTo(second[1]);
                    if (compare == 0) {
                        return first[0].compareTo(second[0]);
                    }
                    return compare;
                }
            });
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                map.put(list.get(j), j);
            }
            int[] numArray = new int[array.length];
            for (int j = 0; j < numArray.length; j++) {
                numArray[j] = map.get(array[j]);
            }
            out.println(numArray.length - LIS.LongestIncreasingSubsequenceLength(numArray, numArray.length));
        }
        out.close();
    }

    static class LIS {
        // Binary search (note boundaries in the caller)
        // A[] is ceilIndex in the caller
        static int CeilIndex(int A[], int l, int r, int key) {
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                if (A[m] >= key) {
                    r = m;
                } else {
                    l = m;
                }
            }

            return r;
        }

        static int LongestIncreasingSubsequenceLength(int A[], int size) {
            // Add boundary case, when array size is one

            int[] tailTable = new int[size];
            int len; // always points empty slot

            tailTable[0] = A[0];
            len = 1;
            for (int i = 1; i < size; i++) {
                if (A[i] < tailTable[0]) {
                    // new smallest value
                    tailTable[0] = A[i];
                }

                else if (A[i] > tailTable[len - 1]) {
                    // A[i] wants to extend largest subsequence
                    tailTable[len++] = A[i];
                }

                else {
                    // A[i] wants to be current end candidate of an existing
                    // subsequence. It will replace ceil value in tailTable
                    tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
                }
            }
            return len;
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