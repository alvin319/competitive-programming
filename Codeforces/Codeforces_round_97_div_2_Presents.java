import java.util.Scanner;

/**
 * Created by alvin on 8/14/16.
 */
public class Codeforces_round_97_div_2_Presents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] newArray = new int[input.nextInt()];
        for (int i = 0; i < newArray.length; i++) {
            int count = input.nextInt();
            newArray[count - 1] = i + 1;
        }
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(i == 0 ? newArray[i] : " " + newArray[i]);
        }
    }
}
