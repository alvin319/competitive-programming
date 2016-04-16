import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 4/15/16.
 */

public class Population {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int countries = input.nextInt();
            int documents = input.nextInt();
            HashMap<Long, Long> map = new HashMap<Long, Long>();

            for (long j = 0; j < countries; j++) {
                long population = input.nextLong();
                map.put(j + 1, population);
            }

            for (int j = 0; j < documents; j++) {
                long currentCountry = input.nextLong();
                long currentChange = input.nextLong();
                map.put(currentCountry, map.get(currentCountry) + currentChange);
            }

            for (long j = 0; j < countries; j++) {
                if(j == 0) {
                    System.out.print(map.get(j + 1));
                } else {
                    System.out.print(" " + map.get(j + 1));
                }
            }
            System.out.println();
        }
    }
}