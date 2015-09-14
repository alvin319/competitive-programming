import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/13/15.
 */
public class Codeforces_round_56_SerialTime {

    public static char[][][] plates;
    public static boolean[][][] visited;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int layers = input.nextInt();
        int rows = input.nextInt();
        int columns = input.nextInt();
        input.nextLine();
        input.nextLine();
        plates = new char[layers][rows][columns];
        visited = new boolean[layers][rows][columns];
        for (int i = 0; i < layers; i++) {
            for (int j = 0; j < rows; j++) {
                plates[i][j] = input.nextLine().toCharArray();
            }
            input.nextLine();
        }
        int startingL = 0;
        int startingR = input.nextInt();
        int startingC = input.nextInt();
        int total = 0;
        total = recursive(startingL, startingR-1, startingC-1);
        System.out.println(total);
    }

    public static int recursive(int l, int r, int c) {
        if(!isValid(l, r, c) || visited[l][r][c])
            return 0;
        char current = plates[l][r][c];
        if(current == '.') {
            visited[l][r][c] = true;
            return 1 + recursive(l, r, c + 1) + recursive(l, r, c - 1) + recursive(l, r + 1, c) + recursive(l, r - 1, c) + recursive(l + 1, r, c) + recursive(l - 1, r, c);
        }
        visited[l][r][c] = true;
        return 0;
    }

    public static boolean isValid(int l, int r, int c) {
        return (l >= 0 && l < plates.length && r >= 0 && r < plates[l].length && c >= 0 && c < plates[l][r].length);
    }
}