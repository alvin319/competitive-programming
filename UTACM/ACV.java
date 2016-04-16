import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/30/15.
 */
public class ACV {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for(int i = 1; i <= cases; i++) {
            int users = input.nextInt();
            double amount = 0;
            input.nextLine();
            for(int j = 1; j <= users; j++) {
                String[] total = input.nextLine().split(" ");
                String type = total[1];
                int slot = Integer.parseInt(total[0]);
                if(slot == j) {
                    if (type.equals("Monthly"))
                        amount += (9.99 * 12);
                    else if (type.equals("Annual"))
                        amount += (99);
                }
            }
            DecimalFormat format = new DecimalFormat("0.00");
            System.out.println(format.format(amount));

        }
    }
}
