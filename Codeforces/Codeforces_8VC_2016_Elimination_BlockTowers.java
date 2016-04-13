import java.util.Scanner;

/**
 * Created by Alvin on 4/12/2016.
 */
public class Codeforces_8VC_2016_Elimination_BlockTowers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int x = 2*n > 3*m ? 2*n : 3*m;
        while( x/2 + x/3 - x/6 < n+m )
            x++;
        System.out.println(x);
    }
}