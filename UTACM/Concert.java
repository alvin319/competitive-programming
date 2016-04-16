import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/5/16.
 */
public class Concert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 1; i <= count; i++) {
            long[][] matrix = new long[input.nextInt()][input.nextInt()];
            int perR = input.nextInt();
            int perC = input.nextInt();
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix[j].length; k++) {
                    matrix[j][k] = input.nextLong();
                }
            }
            long totalCount = DFS(matrix, perR, perC);
            System.out.println(totalCount);
        }

    }

    public static long DFS(long[][] matrix, int row, int col) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length || matrix[row][col] <= 0)
            return 0;
        long answer = matrix[row][col];
        matrix[row][col] = 0;
        return answer + DFS(matrix, row-1, col) + DFS(matrix, row+1, col) + DFS(matrix, row, col-1) + DFS(matrix, row, col+1) + DFS(matrix, row-1, col+1) + DFS(matrix, row-1, col-1) + DFS(matrix, row+1, col-1) + DFS(matrix, row+1, col+1);
    }
}
