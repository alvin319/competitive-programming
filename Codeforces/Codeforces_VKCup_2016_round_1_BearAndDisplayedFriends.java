import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by WiNDWAY on 4/4/16.
 */
public class Codeforces_VKCup_2016_round_1_BearAndDisplayedFriends {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int q = input.nextInt();
        int[] friends = new int[n];
        for (int i = 0; i < n; i++) {
            friends[i] = input.nextInt();
        }
        ArrayList<Friend> friendList = new ArrayList<Friend>();
        for (int i = 0; i < q; i++) {
            int type = input.nextInt();
            int friend = input.nextInt();
            if(type == 1) {
                friendList.add(new Friend(friend));
                if(friendList.size() > k) {
                    int worstFriendValue = Integer.MAX_VALUE;
                    Friend worstFriend = null;
                    for(Friend current : friendList) {
                        if(worstFriendValue > friends[current.id - 1]) {
                            worstFriendValue = friends[current.id - 1];
                            worstFriend = current;
                        }
                    }
                    friendList.remove(worstFriend);
                }
            } else {
                boolean found = false;
                for(Friend x : friendList) {
                    if(x.id == friend) {
                        found = true;
                        break;
                    }
                }
                if(found) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

class Friend {
    int id;

    public Friend(int id) {
        this.id = id;
    }
}
