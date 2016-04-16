import java.util.Scanner;

/**
 * Created by WiNDWAY on 10/30/15.
 */
public class Blog {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        input.nextLine();
        for(int i = 1; i <= testCase; i++) {
            String next = input.nextLine();
            if(next.equals("Dropbox"))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
