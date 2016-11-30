import java.util.*;

/**
 * Created by WiNDWAY on 4/29/16.
 */

public class UVa_272_TEXQuotes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            StringBuilder current = new StringBuilder(input.nextLine());
            int rotation = 0;
            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) == '"') {
                    current.replace(i, i + 1, rotation % 2 == 0 ? "``" : "''");
                    rotation++;
                }
            }
            System.out.println(current.toString());
        }
    }
}