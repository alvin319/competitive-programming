import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Alvin on 8/13/2015.
 */
public class Codeforces_round_315_div_2_Inventory {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int arraySize = input.nextInt();
        int[] numbers = new int[arraySize];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int x : numbers) {
            if(hashMap.get(x) == null)
                hashMap.put(x, 1);
            else
                hashMap.put(x, hashMap.get(x)+1);
        }
        LinkedList<Integer> missing = new LinkedList<Integer>();
        for(int i=1;i<=arraySize;i++) {
            missing.add(i);
        }
        missing.removeAll(hashMap.keySet());
        for (int i = 0; i < numbers.length; i++) {
            if(hashMap.get(numbers[i]) > 1 || numbers[i] > numbers.length) {
                hashMap.put(numbers[i], hashMap.get(numbers[i])-1);
                numbers[i] = missing.removeFirst();
            }
        }
        for(int x : numbers)
            System.out.print(x+" ");
    }
}
