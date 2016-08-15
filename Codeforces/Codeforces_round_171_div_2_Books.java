import java.util.Scanner;

/**
 * Created by alvin on 8/14/16.
 */
public class Codeforces_round_171_div_2_Books {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        int free = input.nextInt();
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        int sum = 0;
        int books = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            while (sum > free) {
                sum -= array[startIndex];
                startIndex++;
            }
            books = Math.max(books, i - startIndex + 1);
        }
        System.out.println(books);
    }
}
