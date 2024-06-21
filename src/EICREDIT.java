
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
public class EICREDIT {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Map<String, Student> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.next();
            Student student = map.get(name);
            if (student == null) {
                student = new Student(name);
                map.put(name, student);
            }

            int course = reader.nextInt();
            int passCourse = 0;
            for (int j = 0; j < course; j++) {
                int score = reader.nextInt();
                if (score >= 50) {
                    passCourse++;
                }
            }
            student.credit = passCourse * 4;
            sb.append(student.name).append(" ").append(student.credit).append("\n");
        }

        System.out.println(sb);

    }

    static class Student {

        String name;
        int credit;

        public Student(String name) {
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
