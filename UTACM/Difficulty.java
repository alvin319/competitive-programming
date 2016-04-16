import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WiNDWAY on 10/16/15.
 */
public class Difficulty {

    public static HashMap<String, Course> classList;

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(input.readLine());
        for(int i = 1; i <= testCases; i++) {
            classList = new HashMap<String, Course>();
            int numClasses = Integer.parseInt(input.readLine());
            for(int j = 1; j <= numClasses; j++) {
                String[] classes = input.readLine().split(" ");
                String course = classes[0];
                long diff = l(classes[1]);
                int reqs = Integer.parseInt(classes[2]);
                Course newClass = new Course(diff);
                if(reqs > 0) {
                    String[] preReqs = input.readLine().split(" ");
                    for(int k = 0; k < preReqs.length; k++) {
                        newClass.preReqs.add(preReqs[k]);
                    }
                }
                classList.put(course, newClass);
            }

            String hardestClass = "";
            long hardestValue = -1;

            for(String courseName : classList.keySet()) {
                Course newCourse = classList.get(courseName);
                if(newCourse.preReqs.size() > 0) {
                    newCourse.diff = recursiveCall(courseName, new HashSet<String>());
                    if (newCourse.diff >= hardestValue) {
                        hardestValue = newCourse.diff;
                        hardestClass = courseName;
                    }
                }
            }

            System.out.println(hardestClass + " " + hardestValue);
            classList.clear();
        }
    }

    public static long l(String x) {
        return Long.parseLong(x);
    }

    public static long recursiveCall(String courseName, HashSet<String> repeats) {
        if(classList.get(courseName).preReqs.size() == 0) {
            repeats.add(courseName);
            return classList.get(courseName).diff;
        }
        long newDiff = classList.get(courseName).diff;
        for(String x : classList.get(courseName).preReqs) {
            if(!repeats.contains(x)) {
                newDiff += recursiveCall(x, repeats);
                repeats.add(x);
            }
        }
        Course newCourse = classList.get(courseName);
        newCourse.diff = newDiff;
        classList.put(courseName, newCourse);
        return newDiff;
    }

    public static class Course {
        long diff;
        HashSet<String> preReqs;

        public Course(long diff) {
            this.diff = diff;
            preReqs = new HashSet<String>();
        }
    }

}