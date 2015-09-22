import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/21/15.
 */
public class Codeforces_round_7_KalevitchAndChess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] grid = new char[8][8];
        int answer = 0;
        for(int i = 0; i < grid.length; i++) {
            char[] current = input.nextLine().toCharArray();
            boolean isPaint = true;
            for(char x : current) {
                if(x != 'B')
                    isPaint = false;
            }
            grid[i] = current;
            if(isPaint)
                answer++;
        }

        for(int i = 0; i < grid.length; i++) {
            boolean isPaint = true;
            for(int j = 0; j < grid.length; j++)  {
                if(grid[j][i] != 'B')
                    isPaint = false;
            }
            if(isPaint)
                answer++;
        }
        if(answer == 16)
            System.out.println(answer / 2);
        else
            System.out.println(answer);
    }
}
