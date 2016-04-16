import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/19/16.
 */
public class Sunshine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 0; i < count; i++) {
            int emotions = input.nextInt();
            input.nextLine();
            String[] current = input.nextLine().split(" ");
            ArrayList<String> currentList = new ArrayList<>();
            for(String x : current)
                currentList.add(x);
            boolean angry = currentList.contains("ANGRY");
            boolean sad = currentList.contains("SAD");
            boolean happy = currentList.contains("HAPPY");
            boolean calm = currentList.contains("CALM");
            boolean jealous = currentList.contains("JEALOUS");
            boolean exhausted = currentList.contains("EXHAUSTED");
            if(exhausted) {
                System.out.println("NO");
            } else if(calm){
                if(sad && (happy || angry))
                    System.out.println("YES");
            } else if(sad && !(happy || angry)) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
