import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumberFollowing {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(34);
        list.add(8);
        list.add(31);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String objectOne = o1 + "" + o2;
                String objectTwo = o2 + "" + o1;
                return -objectOne.compareTo(objectTwo);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int number : list) {
            stringBuilder.append(number);
        }
        System.out.println(stringBuilder);

    }
}
