import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WiNDWAY on 5/13/16.
 */

public class Codeforces_VKCup_2016_round_2_LittleArtemAndDance {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int boys = input.nextInt();
        int commands = input.nextInt();
        int firstBoyIndex = 0;
        int secondBoyIndex = 1;
        int[] boysArray = new int[boys];
        for (int i = 0; i < commands; i++) {
            int order = input.nextInt();
            if (order == 2) {
                if (firstBoyIndex % 2 == 0) {
                    firstBoyIndex++;
                } else {
                    firstBoyIndex--;
                }
                if (secondBoyIndex % 2 == 0) {
                    secondBoyIndex++;
                } else {
                    secondBoyIndex--;
                }
            } else if (order == 1) {
                int move = input.nextInt();
                firstBoyIndex += move;
                secondBoyIndex += move;
                if (firstBoyIndex >= boys) {
                    firstBoyIndex -= boys;
                } else if (firstBoyIndex < 0) {
                    firstBoyIndex += boys;
                }
                if (secondBoyIndex >= boys) {
                    secondBoyIndex -= boys;
                } else if (secondBoyIndex < 0) {
                    secondBoyIndex += boys;
                }
            }
        }
        Arrays.fill(boysArray, -1);
        boysArray[firstBoyIndex] = 1;
        boysArray[secondBoyIndex] = 2;
        int oddBoyCounter = 1;
        int oddBoyValue = 3;
        int oddBoyIndex = firstBoyIndex + 2;
        if (oddBoyIndex >= boys) {
            oddBoyIndex -= boys;
        }
        while (oddBoyCounter < boys / 2) {
            boysArray[oddBoyIndex] = oddBoyValue;
            oddBoyValue += 2;
            oddBoyCounter++;
            oddBoyIndex += 2;
            if (oddBoyIndex >= boys) {
                oddBoyIndex -= boys;
            }
        }
        int evenBoyCounter = 1;
        int evenBoyValue = 4;
        int evenBoyIndex = secondBoyIndex + 2;
        if (evenBoyIndex >= boys) {
            evenBoyIndex -= boys;
        }
        while (evenBoyCounter < boys / 2) {
            boysArray[evenBoyIndex] = evenBoyValue;
            evenBoyValue += 2;
            evenBoyCounter++;
            evenBoyIndex += 2;
            if (evenBoyIndex >= boys) {
                evenBoyIndex -= boys;
            }
        }
        for (int i = 0; i < boys; i++) {
            out.print(i == 0 ? boysArray[i] : " " + boysArray[i]);
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