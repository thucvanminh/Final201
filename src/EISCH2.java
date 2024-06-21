
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class EISCH2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        List<Student> students = new ArrayList<>();
        int[] scholarships = new int[]{n / 12, n / 3, n / 2};
        String[] types = new String[]{"A", "B", "C"};

        for (int i = 0; i < n; i++) {
            String name = reader.next();
            int course = reader.nextInt();
            double avg = 0.0;
            int passCourse = 0;
            int totalScore = 0;
            for (int j = 0; j < course; j++) {
                int score = reader.nextInt();
                if (score >= 50) {
                    passCourse++;
                    totalScore += score;
                }
            }
            Student student;
            if (passCourse == 0) {
                student = new Student(name, 0);
                students.add(student);
            } else {
                student = new Student(name, (double) totalScore / passCourse);
                students.add(student);
            }
        }

        students.sort(
                (s1, s2) -> {
                    if (Double.compare(s2.avg, s1.avg) == 0) {
                        return s1.name.compareTo(s2.name);
                    }
                    return Double.compare(s2.avg, s1.avg);
                }
        );

        int j = 0;
        for (int i = 0; i < scholarships.length; i++) {
            for (; j < scholarships[i]; j++) {
                if (Double.compare(students.get(j).avg, students.get(scholarships[i]).avg) != 0) {
                    sb.append(students.get(j).name).append(" ").append((double) Math.round(students.get(j).avg * 100) / 100).append(" ").append(types[i]).append("\n");
                } else {
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Student {

        String name;
        double avg;

        public Student(String name, double avg) {
            this.name = name;
            this.avg = avg;
        }
    }

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
