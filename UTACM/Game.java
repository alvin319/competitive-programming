import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/19/16.
 */
public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int cups = input.nextInt();
            int commands = input.nextInt();
            int start = input.nextInt();
            input.nextLine();
            for (int j = 0; j < commands; j++) {
                String next = input.nextLine();
                if(next.equals("REVERSE")) {
                    start = (cups - 1 - start);
                } else {
                    String[] instr = next.split(" ");
                    int indexOne = Integer.parseInt(instr[1]);
                    int indexTwo = Integer.parseInt(instr[2]);
                    if(indexOne == start) {
                        start = indexTwo;
                    } else if (indexTwo == start) {
                        start = indexOne;
                    }
                }
            }
            System.out.println(start);
        }
    }
}
