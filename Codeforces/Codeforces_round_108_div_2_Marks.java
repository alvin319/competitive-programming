import java.io.*;
import java.util.*;

/**
 * Created by Alvin on 7/30/2016.
 */

public class Codeforces_round_108_div_2_Marks {
    public static void main(String[] args) {
        FScanner input = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        HashSet<Integer> student = new HashSet<>();
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] array = input.nextLine().toCharArray();
            for (int j = 0; j < array.length; j++) {
                matrix[i][j] = array[j] - '0';
            }
        }
        for (int i = 0; i < m; i++) {
            PriorityQueue<Student> queue = new PriorityQueue<>(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return new Integer(o1.grade).compareTo(o2.grade);
                }
            });
            for (int j = 0; j < n; j++) {
                int currentGrade = matrix[j][i];
                if (queue.peek() == null || currentGrade > queue.peek().grade) {
                    queue.clear();
                    queue.add(new Student(currentGrade, j));
                } else if (currentGrade == queue.peek().grade) {
                    queue.add(new Student(currentGrade, j));
                }
            }
            for (Student currentStudent : queue) {
                student.add(currentStudent.index);
            }
        }
        out.println(student.size());
        out.close();
    }

    public static class Student {
        int grade;
        int index;

        public Student(int grade, int index) {
            this.grade = grade;
            this.index = index;
        }
    }
    public static PrintWriter out;

    public static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

