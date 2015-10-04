import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Alvin on 10/3/2015.
 */
public class Codeforces_round_75_div_2_BinaryNumber {

    public static int totalCount = 0;
    public static ArrayList<Integer> currentList;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        currentList = new ArrayList<Integer>();
        String current = input.nextLine();
        for(int i = current.length() - 1; i >= 0; i--) {
            if(current.charAt(i) == '0') {
                totalCount++;
            } else {
                break;
            }
        }
        current = current.substring(0, current.length()-totalCount);
        for(char x : current.toCharArray()) {
            currentList.add((int)x - 48);
        }
        while(!(currentList.size() == 1 && currentList.get(0) == 1) && currentList.size() > 1) {
            if(currentList.get(currentList.size() - 1) == 1) {
                int carryOver = 1;
                for(int i = currentList.size() - 1; i >= 0 && carryOver != 0; i--) {
                    int result = currentList.get(i) + carryOver;
                    carryOver = result / 2;
                    result %= 2;
                    currentList.set(i, result);
                }
                totalCount++;
            }
            int newIter = 0;
            for(int i = currentList.size() - 1; i >= 0; i--) {
                if(currentList.get(i) == 0) {
                    newIter++;
                } else {
                    break;
                }
            }
            currentList.subList(currentList.size() - newIter, currentList.size()).clear();
            totalCount += newIter;
        }
        System.out.println(totalCount);
    }
}
