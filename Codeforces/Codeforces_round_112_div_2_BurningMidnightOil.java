import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/30/15.
 */

public class Codeforces_round_112_div_2_BurningMidnightOil {

    public static int n;
    public static int k;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        System.out.println(binarySearch(1, n/2, n));
    }


    public static int isValid(int v, int n, int k) {
        int total = v;
        int power = 2;
        int result = k;
        while((v / result) != 0) {
            total += (v / result);
            result = (int)(Math.pow(k, power));
            power++;

        }
        return (n - total);
    }

    public static int binarySearch(int start, int mid, int end) {
        if(end >= start) {
            mid = (start + end) / 2;
            if(isValid(mid, n, k) <= 0)
                return binarySearch(start, mid, mid - 1 );
            return binarySearch(mid+1, mid, end);

        }
        return start;
    }
}
