import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Alvin on 8/16/2015.
 */
public class random_programming_challenge_3 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String original = input.nextLine();
        int splitCount = input.nextInt();
        ArrayList<String> sortList = new ArrayList<String>();
        for(int i=0; i<original.length()-2; i++) {
            sortList.add(original.substring(i,i+splitCount));
        }
        Collections.sort(sortList);
        System.out.println(sortList.get(0)+" is smallest among them and "+sortList.get(sortList.size()-1)+" is largest.");
    }
}
