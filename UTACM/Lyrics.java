import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by WiNDWAY on 2/5/16.
 */
public class Lyrics {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        for (int i = 1; i <= count; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int l = input.nextInt();
            HashMap<String, Long> wordCount = new HashMap<String, Long>();
            input.nextLine();
            int req = 0;
            for (int j = 1; j <= l; j++) {
                String[] words = input.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                for (String current : words) {
                    if (!wordCount.containsKey(current)) {
                        wordCount.put(current, (long) 1);
                    } else {
                        wordCount.put(current, wordCount.get(current) + 1);
                    }
                }
            }
            for(String k : wordCount.keySet()) {
                if(wordCount.get(k) >= y)
                    req++;
            }
            if(req >= x)
                System.out.println("WRITE");
            else
                System.out.println("LET IT GO");

        }

    }
}
