import java.util.Scanner;

/**
 * Created by Alvin on 11/18/2015.
 */
public class Codeforces_round_95_div_2_TheWorldIsATheatre {


    public static long pascalT(int n, int m) {

        long[][] C = new long[100][100];
        for(int i = 0; i < 31; i++)
            C[i][0] = C[0][i] = 1;
        for(int i = 1; i < 31; i++) {
            for(int j = 1; j <= i; j++) {
                C[i][j] = (i != j) ? C[i - 1][j] + C[i - 1][j - 1] : 1;
            }
        }
        return C[n][m];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int t = input.nextInt();

        long result = 0;

        for (int i = 1; i < t; i++) {
            if(t - i < 4)
                break;
            if(i > m)
                break;
            result += pascalT(m, i) * pascalT(n, t - i);
        }

        System.out.println(result);
    }
}