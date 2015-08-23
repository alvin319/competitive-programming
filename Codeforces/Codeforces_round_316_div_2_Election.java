/**
 * Created by Alvin on 8/22/2015.
 */

import java.util.*;
import java.io.*;

public class Codeforces_round_316_div_2_Election {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int candidateCount = input.nextInt();
        int cityCount = input.nextInt();
        final HashMap<Integer, Integer> voteCount = new HashMap<Integer, Integer>();
        for(int i=1;i<=candidateCount;i++) {
            voteCount.put(i,0);
        }
        for(int i=1;i<=cityCount;i++) {
            int[] cityVote = new int[candidateCount];
            for(int j=0; j<cityVote.length; j++)
                cityVote[j] = input.nextInt();
            int maxVote = -1;
            int maxVoteIndex = -1;
            for(int j=0; j<cityVote.length; j++) {
                if (maxVote == cityVote[j] && j < maxVoteIndex) {
                    maxVoteIndex = j;
                }
                else if(maxVote < cityVote[j]) {
                    maxVote = cityVote[j];
                    maxVoteIndex = j;
                }
            }
            voteCount.put(maxVoteIndex+1, voteCount.get(maxVoteIndex+1)+1);
        }
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        for(int i=1;i<=candidateCount;i++)
            sortedList.add(i);
        Collections.sort(sortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(voteCount.get(o1) == voteCount.get(o2))
                    return o1.compareTo(o2);
                return voteCount.get(o1) > voteCount.get(o2) ? -1 : 1;
            }
        });
        System.out.println(sortedList.get(0));
    }
}
