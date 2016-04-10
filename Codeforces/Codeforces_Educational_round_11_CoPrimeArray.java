import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvin on 4/9/2016.
 */
public class Codeforces_Educational_round_11_CoPrimeArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(input.nextInt());
        }
        int added = 0;
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int previous = list.get(i - 1);
            if(gcd(current, previous) != 1) {
                list.add(i, 1);
                added++;
            }
        }
        System.out.println(added);
        for(int x : list) {
            System.out.print(x + " ");
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
}
