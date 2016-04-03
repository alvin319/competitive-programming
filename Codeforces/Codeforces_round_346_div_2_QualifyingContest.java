import java.util.*;

/**
 * Created by Alvin on 4/2/2016.
 */
public class Codeforces_round_346_div_2_QualifyingContest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] maxInfo = new int[m];
        int[] maxCount = new int[m];
        for (int i = 0; i < maxCount.length; i++) {
            maxCount[i] = 0;
        }
        for (int i = 0; i < maxInfo.length; i++) {
            maxInfo[i] = Integer.MIN_VALUE;
        }

        HashMap<Integer, ArrayList<Person>> roster = new HashMap<Integer, ArrayList<Person>>();
        for (int i = 1; i <= m; i++) {
            roster.put(i, new ArrayList<Person>());
        }
        input.nextLine();
        for (int i = 0; i < n; i++) {
            String[] info = input.nextLine().split(" ");
            String name = info[0];
            int region = Integer.parseInt(info[1]);
            int score = Integer.parseInt(info[2]);
            roster.get(region).add(new Person(name, region, score));
            int best = maxInfo[region - 1];
            if (score > best) {
                maxInfo[region - 1] = score;
                maxCount[region - 1] = 1;
            } else if (score == best) {
                maxCount[region - 1]++;
            }
        }
        for (Integer x : roster.keySet()) {
            ArrayList<Person> current = roster.get(x);
            Collections.sort(current, new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return Integer.compare(o1.score, o2.score);
                }
            });
        }
        for (Integer x : roster.keySet()) {
            ArrayList<Person> current = roster.get(x);
            if (maxCount[x - 1] > 2) {
                System.out.println("?");
            } else if(current.size() >= 3 && (current.get(current.size() - 2).score == current.get(current.size() - 3).score)) {
                System.out.println("?");
            } else {
                System.out.println(current.get(current.size() - 1) + " " + current.get(current.size() - 2));
            }
        }
    }
}

class Person {
    String name;
    int score;
    int region;

    public Person(String name, int region, int score) {
        this.name = name;
        this.region = region;
        this.score = score;
    }

    public String toString() {
        return name;
    }
}