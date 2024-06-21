
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
class EIUSLS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int n = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = reader.next();
            int numCourses = reader.nextInt();
            int totalPassScore = 0;

            for (int j = 0; j < numCourses; j++) {
                totalPassScore += reader.nextInt();
            }

            double avg = (double) totalPassScore / numCourses;
            students[i] = new Student(name, avg);
        }

        Arrays.sort(students, (s1, s2) -> Double.compare(s2.avg, s1.avg));

        if (students.length == 1) {
            sb.append(students[0].name);
        } else {
            for (int i = 0; i < 2; i++) {
                sb.append(students[i].name).append("\n");
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
