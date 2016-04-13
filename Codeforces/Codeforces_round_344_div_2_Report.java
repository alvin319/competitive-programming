import java.util.*;

/**
 * Created by WiNDWAY on 4/11/16.
 */

public class Codeforces_round_344_div_2_Report {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Long> commodities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            commodities.add(input.nextLong());
        }
        int[] orders = new int[m];
        int[] ranges = new int[m];
        LinkedList<Integer> peaks = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            orders[i] = input.nextInt();
            ranges[i] = input.nextInt();
        }
        int currentIndex = m - 1;
        peaks.addFirst(currentIndex);
        int seenRange = ranges[currentIndex];
        currentIndex--;
        while(currentIndex >= 0) {
            int currentRange = ranges[currentIndex];
            if(currentRange > seenRange) {
                peaks.addFirst(currentIndex);
                seenRange = currentRange;
            }
            currentIndex--;
        }
        for(int index : peaks) {
            int currentOrder = orders[index];
            int currentRange = ranges[index];
            if(currentOrder == 1) {
                Collections.sort(commodities.subList(0, currentRange));
            } else {
                Collections.sort(commodities.subList(0, currentRange), Collections.reverseOrder());
            }
        }
        for(long x : commodities) {
            System.out.print(x + " ");
        }
    }
}