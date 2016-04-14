import java.util.*;

/**
 * Created by Alvin on 4/12/2016.
 */
public class Codeforces_Educational_round_9_TheSmallestStringConcatenation {

    static int maxLength = -1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        ArrayList<String> list = new ArrayList<>();
        input.nextLine();
        for (int i = 0; i < count; i++) {
            String current = input.nextLine();
            list.add(current);
            maxLength = Math.max(maxLength, current.length());
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        String answer = "";
        for(String x : list) {
            answer += x;
        }
        System.out.println(answer);
    }
}
