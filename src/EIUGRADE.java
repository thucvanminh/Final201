
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
public class EIUGRADE {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Map<Integer, Student> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            int id = reader.nextInt();
            Student student = map.get(id);
            if (student == null) {
                student = new Student(id);
                map.put(id, student);
            }

            int course = reader.nextInt();
            double score = reader.nextDouble();
            student.course++;
            student.sum += score;
        }

        List<Student> students = new ArrayList<>(map.values());

        for (int i = 0; i < students.size(); i++) {
            students.get(i).avg = students.get(i).sum / students.get(i).course;
        }
        students.sort((s1, s2)
                -> {
            int avgCompare = Double.compare(s2.avg, s1.avg);
            if (avgCompare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return avgCompare;
        });

        for (int i = 0; i < students.size(); i++) {
            sb.append(students.get(i).id).append(" ").append(Math.round(students.get(i).avg*1000.0)/1000.0).append("\n");
        }

        System.out.println(sb);

    }

    static class Student {

        int id;
        int course;
        double sum;
        double avg;

        public Student(int id) {
            this.id = id;
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
