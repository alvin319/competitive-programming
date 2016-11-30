import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.*;

/**
 * Created by Alvin on 8/7/2015.
 */
public class AlphaFun {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("alphafun.dat"));
        ArrayList<String> stringArrayList = new ArrayList<String>();
        while (input.hasNext()) {
            stringArrayList.add(input.nextLine());
        }
        Collections.sort(stringArrayList, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                char fourthFirst = (first.length() >= 4) ? first.charAt(3) : ' ';
                char fourthSecond = (second.length() >= 4) ? second.charAt(3) : ' ';
                if (first.charAt(1) != second.charAt(1))
                    return first.charAt(1) > second.charAt(1) ? 1 : -1;
                if (fourthFirst != fourthSecond)
                    return fourthFirst > fourthSecond ? 1 : -1;
                if (first.charAt(first.length() - 1) != second.charAt(second.length() - 1))
                    return first.charAt(first.length() - 1) > second.charAt(second.length() - 1) ? 1 : -1;
                if (first.charAt(0) != second.charAt(0))
                    return first.charAt(0) > second.charAt(0) ? 1 : -1;
                return first.compareTo(second);
            }
        });
        for (String x : stringArrayList)
            System.out.println(x);
    }
}
