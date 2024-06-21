
import java.io.*;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIGRADU {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Student> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int id = reader.nextInt();
            String name = reader.next();
            Student student = map.get(id);
            if (student == null) {
                student = new Student(id, name);
                map.put(id, student);
            }

            int course = reader.nextInt();
            int passCourse = 0;
            double totalPassScore = 0;
            for (int j = 0; j < course; j++) {
                int score = reader.nextInt();
                if (score >= 50) {
                    passCourse++;
                    totalPassScore += score;
                }
            }
            if (passCourse * 4 >= m) {
                student.avg = Math.floor(totalPassScore / passCourse);
            } else {
                student.avg = 0;
            }
        }

        List<Student> students = new ArrayList<>(map.values());
        students.sort((s1, s2)
                -> {
            int avgCompare = Double.compare(s2.avg, s1.avg);
            if (avgCompare == 0){
                return Integer.compare(s1.id, s2.id);
            }
            return avgCompare;
        });

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).avg != 0) {
                sb.append(students.get(i).id).append(" ").append(students.get(i).name).append(" ").append((int) students.get(i).avg).append("\n");
            }
        }

        System.out.println(sb);

    }

    static class Student {

        int id;
        String name;
        double avg;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
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
