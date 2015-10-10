import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/10/15.
 */

// 13 5 7
public class Codeforces_round_119_div_2_CutRibbon {

    public static int[] slots;
    public static int a;
    public static int b;
    public static int c;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        a = input.nextInt();
        b = input.nextInt();
        c = input.nextInt();
        slots = new int[4001];
        Arrays.fill(slots, -1);
        int min = Math.min(a, Math.min(b, c));
        slots[min] = 1;
        for(int i = 1; i <= n; i++) {
            constructSlots(i);
        }
        System.out.println(slots[n]);
    }
    public static int constructSlots(int find) {
        if(find <= 0)
            return 0;
        if(slots[find] != -1)
            return slots[find];
        int aCoin = constructSlots(find - a);
        int bCoin = constructSlots(find - b);
        int cCoin = constructSlots(find - c);
        int result = Math.max(aCoin, Math.max(bCoin, cCoin));
        boolean basePiece = (find == a || find == b || find == c);
        if(result == 0 && basePiece) {
            slots[find] = 1;
        } else if(result == 0 && !basePiece) {
            slots[find] = 0;
        } else {
            slots[find] = result + 1;
        }
        return slots[find];
    }

}
