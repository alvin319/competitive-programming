import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/4/16.
 */
public class Codeforces_round_345_div_2_Joysticks {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first = input.nextInt();
        int second = input.nextInt();
        int minutes = 0;
        while(first > 0 && second > 0) {
            if(first == 1 && second == 1)
                break;
            if(first >= second) {
                first -= 2;
                second++;
                minutes++;
            } else {
                second -= 2;
                first++;
                minutes++;
            }
        }
        System.out.println(minutes);
    }
}
