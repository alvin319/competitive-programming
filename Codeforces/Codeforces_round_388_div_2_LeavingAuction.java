import java.io.*;
import java.util.*;

/**
 * Created by WiNDWAY on 12/19/16.
 */

public class Codeforces_round_388_div_2_LeavingAuction {

    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int n = input.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> highBidding = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int player = input.nextInt();
            int amount = input.nextInt();
            if (!map.containsKey(player)) {
                map.put(player, new ArrayList<>());
                highBidding.put(player, amount);
            }
            highBidding.put(player, Math.max(amount, highBidding.get(player)));
            map.get(player).add(amount);
        }
        ArrayList<Integer> highestBidList = new ArrayList<>(highBidding.keySet());
        Collections.sort(highestBidList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return highBidding.get(o1).compareTo(highBidding.get(o2));
            }
        });
        int situations = input.nextInt();
        for (int i = 0; i < situations; i++) {
            int remove = input.nextInt();
            HashSet<Integer> removedPlayers = new HashSet<>();
            for (int j = 0; j < remove; j++) {
                int player = input.nextInt();
                removedPlayers.add(player);
            }
            ArrayList<Integer> topWinners = new ArrayList<>();
            int loopIndex = highestBidList.size() - 1;
            while (topWinners.size() < 2 && loopIndex >= 0) {
                int playerID = highestBidList.get(loopIndex);
                if (!removedPlayers.contains(playerID)) {
                    topWinners.add(playerID);
                }
                loopIndex--;
            }
            if (topWinners.size() == 1) {
                int winner = topWinners.get(0);
                ArrayList<Integer> list = map.get(winner);
                out.println(winner + " " + list.get(0));
            } else if (topWinners.isEmpty()) {
                out.println("0 0");
            } else {
                int firstWinner = topWinners.get(0);
                int secondWinner = topWinners.get(1);
                if (map.get(firstWinner).get(map.get(firstWinner).size() - 1) > map.get(secondWinner).get(map.get(secondWinner).size() - 1)) {
                    ArrayList<Integer> secondList = map.get(secondWinner);
                    int biggestSecondElement = secondList.get(secondList.size() - 1);
                    int index = ~Collections.binarySearch(map.get(firstWinner), biggestSecondElement);
                    out.println(firstWinner + " " + map.get(firstWinner).get(index));
                } else {
                    ArrayList<Integer> firstList = map.get(firstWinner);
                    int biggestFirstElement = firstList.get(firstList.size() - 1);
                    int index = ~Collections.binarySearch(map.get(secondWinner), biggestFirstElement);
                    out.println(secondWinner + " " + map.get(secondWinner).get(index));
                }
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