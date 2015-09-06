import java.util.Scanner;

/**
 * Created by WiNDWAY on 9/4/15.
 */
public class Codeforces_round_222_div_1_Maze {

    public static char[][] matrix;
    public static int leftCount;
    public static int requirementCount;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        leftCount = input.nextInt();
        input.nextLine();
        matrix = new char[n][m];

        int x = -1;
        int y = -1;
        int nodeCount = 0;

        for (int i = 0; i < matrix.length; i++) {
            char[] path = input.nextLine().toCharArray();
            for (int j = 0; j < path.length; j++) {
                if (path[j] == '.') {
                    x = i;
                    y = j;
                    nodeCount++;
                }
            }
            matrix[i] = path;
        }
        requirementCount = nodeCount - leftCount;

        startDFS(x, y);
        if (leftCount >= 1) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    switch (matrix[i][j]) {
                        case 'V':
                            System.out.print('.');
                            break;
                        case '.':
                            System.out.print('X');
                            break;
                        default:
                            System.out.print(matrix[i][j]);
                            break;
                    }
                }
                System.out.println();
            }
        } else {
            for (char[] s : matrix) {
                for (char e : s) {
                    System.out.print(e);
                }
                System.out.println();
            }
        }
    }

    public static void startDFS(int x, int y) {
        if(leftCount <= 0 || !isValid(x, y) || matrix[x][y] == '#' || matrix[x][y] == 'X' || matrix[x][y] == 'V' || requirementCount <= 0)
            return;
        matrix[x][y] = 'V';
        requirementCount--;
        startDFS(x - 1, y);
        startDFS(x + 1, y);
        startDFS(x, y - 1);
        startDFS(x, y + 1);
    }
    public static boolean isWall(int x, int y) {
        char check = getChar(x, y);
        return (check == 'X') || (check == '#') || (check == 'B');
    }

    public static boolean getReplace(int x, int y) {
        boolean up = isWall(x - 1, y);
        boolean down = isWall(x + 1, y);
        boolean left = isWall(x, y - 1);
        boolean right = isWall(x, y + 1);
        if(up && right && down)
            return true;
        else if(up && left && right)
            return true;
        else if(left && up && down)
            return true;
        else if(down && left && right)
            return true;
        return false;
    }

    public static char getChar(int i, int j) {
        if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length)
            return matrix[i][j];
        return 'B';
    }

    public static boolean isValid(int i, int j) {
        return (i >= 0 && i < matrix.length && j >= 0 && j < matrix[i].length);
    }

    public static void printMatrix() {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[i].length; j++)
//                System.out.print(matrix[i][j] == 'V' ? '.' : matrix[i][j]);
                System.out.print(matrix[i][j]);
            System.out.println();
        }
    }
}
