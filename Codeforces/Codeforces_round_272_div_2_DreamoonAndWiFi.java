import java.util.*;
import java.lang.*;

/**
 * Created by Alvin on 12/1/2015.
 */
public class Codeforces_round_272_div_2_DreamoonAndWiFi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String first = input.nextLine();
        String second = input.nextLine();

        int positive = 0;
        int negative = 0;
        int other = 0;

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == '+') {
                positive++;
            } else {
                negative++;
            } if (second.charAt(i) == '+') {
                positive--;
            } else if (second.charAt(i) == '-') {
                negative--;
            } else {
                other++;
            }
        }

        if (positive < 0 || negative < 0) {
            System.out.println("0");
            return;
        }

        double solution = ((Math.pow(0.5, other)) * factorial(other)) / (factorial(positive) * factorial(negative));
        System.out.println(solution);
    }

    public static double factorial(int start) {
        double answer = 1;
        for(int i = 2; i <= start; i++) {
            answer *= i;
        }
        return answer;
    }
}
