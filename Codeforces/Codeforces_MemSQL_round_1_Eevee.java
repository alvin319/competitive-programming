import java.util.Scanner;

/**
 * Created by Alvin on 4/9/2016.
 */
public class Codeforces_MemSQL_round_1_Eevee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] answers = {"vaporeon", "jolteon", "flareon", "espeon", "umbreon", "leafeon", "glaceon", "sylveon"};
        int count = input.nextInt();
        input.nextLine();
        String guess = input.nextLine();
        for (int i = 0; i < answers.length; i++) {
            if(answers[i].length() == guess.length()) {
                boolean solution = true;
                for (int j = 0; j < guess.length(); j++) {
                    if(answers[i].charAt(j) != guess.charAt(j) && (guess.charAt(j) != '.')) {
                        solution = false;
                    }
                }
                if(solution) {
                    System.out.println(answers[i]);
                }
            }
        }
    }
}
