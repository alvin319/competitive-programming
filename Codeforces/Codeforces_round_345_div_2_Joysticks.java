import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/4/16.
 */
public class Codeforces_round_345_div_2_Joysticks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int second = input.nextInt();
        int[][] matrix = new int[102][102];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }
        matrix[1][1] = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[0][i] = 0;
            matrix[i][0] = 0;
        }
        System.out.println(recursiveDP(first, second, matrix));
    }

    public static int recursiveDP(int first, int second, int[][] matrix) {
        if(first < 0 || second < 0 || (first <= 0 && second <= 0) || first > 101 || second > 101) {
            return 0;
        } else if(matrix[first][second] != -1) {
            return matrix[first][second];
        }
        int current = 1 + Math.max(recursiveDP(first + 1, second - 2, matrix), recursiveDP(first - 2, second + 1, matrix));
        matrix[first][second] = current;
        return matrix[first][second];
    }
}
