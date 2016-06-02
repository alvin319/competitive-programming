import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvin on 4/11/2016.
 */
public class Codeforces_Codefest_16_ATrivialProblem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int requirement = input.nextInt();
        ArrayList<Long> solution = new ArrayList<>();
        for (long i = 1; i <= Integer.MAX_VALUE; i++) {
            if(trailingZero(i) == requirement) {
                solution.add(i);
            } else if(trailingZero(i) > requirement) {
                break;
            }
        }
        System.out.println(solution.size());
        for(long x: solution) {
            System.out.print(x + " ");
        }
    }

    public static long trailingZero(long x) {
        long total = 0;
        long multiple = 5;
        while(x / multiple != 0) {
            total += (x / multiple);
            multiple *= 5;
        }
        return total;
    }
}
