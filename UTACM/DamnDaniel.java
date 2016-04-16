import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by WiNDWAY on 4/1/16.
 */
public class DamnDaniel {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File(("dd1in.txt")));
        Scanner input2 = new Scanner(new File("dd2in.txt"));
        String missing = "";
        while(input.hasNext()) {
            String[] array = input.nextLine().split(" ");
            HashSet<Character> set = new HashSet<Character>();
            for(String x : array) {
                char current = (char)(Integer.parseInt(x) - 1);
                set.add(current);
            }
            int index = 33;
            for(char x : set) {
                if((int)(x) >= 33) {
                    if((int)(x) != index) {
                        missing += (char)((int)x - 1);
                        break;
                    }
                    index++;
                }
            }
        }
        System.out.println(missing);
        String missing2 = "";
        while(input2.hasNext()) {
            String[] array = input2.nextLine().split(" ");
            HashSet<Character> set = new HashSet<Character>();
            for(String x : array) {
                char current = x.charAt(0);
                set.add(current);
            }
            int index = 33;
            for(char x : set) {
//                if((int)(x) >= 33) {
//                    if((int)(x) != index) {
//                        missing2 += (char)((int)x);
//                        break;
//                    }
//                    index++;
//                }
                System.out.print(x + " ");
            }
        }
        System.out.println(missing2);
        Scanner input3 = new Scanner(new File("firstinterview.txt"));
        ArrayList<String> current1 = new ArrayList<>();
        while(input3.hasNext()) {

            String current = input3.nextLine();
            current1.add(new StringBuffer(current).reverse().toString());
        }
        for (int i = current1.size() - 1; i >= 0; i--) {
            System.out.println(current1.get(i));
        }
    }
}
