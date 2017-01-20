import java.io.IOException;
import java.util.Scanner;

/**
 * Created by alvindeng on 1/20/17.
 */
public class Codeforces_round_392_div_2_BlownGarland {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int[] info = new int[4];
        int r_index = -1;
        int b_index = -1;
        int y_index = -1;
        int g_index = -1;
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case 'R': {
                    r_index = i % 4;
                }
                break;
                case 'B': {
                    b_index = i % 4;
                }
                break;
                case 'Y': {
                    y_index = i % 4;
                }
                break;
                default: {
                    g_index = i % 4;
                }
            }
        }
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '!') {
                int index = i % 4;
                if (index == r_index) {
                    info[0]++;
                } else if (index == b_index) {
                    info[1]++;
                } else if (index == y_index) {
                    info[2]++;
                } else {
                    info[3]++;
                }
            }
        }
        for (int i = 0; i < info.length; i++) {
            System.out.print(i == 0 ? info[i] : " " + info[i]);
        }
    }
}
