import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvin on 4/1/2016.
 */

public class Codeforces_round_346_div_2_TanyaAndToys {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        boolean[] link = new boolean[10000005];
        for (int i = 0; i < list.size(); ++i) {
            if(list.get(i) < link.length) {
                link[list.get(i)] = true;
            }
        }
        link[0] = true;
        for (int i = 1; i <= 10000000; ++i) {
            if (!link[i] && m >= i) {
                m -= i;
                answer.add(i);
            }
        }
        System.out.println(answer.size());
        for (int x : answer)
            System.out.print(x + " ");
    }

}
