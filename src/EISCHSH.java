
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
class EISCHSH {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        // int n = reader.nextInt();
        // int k = reader.nextInt();
        // StringBuilder sb = new StringBuilder();
        // Student[] student = new Student[n];
        //
        // for (int i = 0; i < n; i++) {
        // int id = reader.nextInt();
        // String name = reader.next();
        // int course = reader.nextInt();
        // int passCourse = 0;
        // int totalPassScore = 0;
        // for (int j = 0; j < course; j++) {
        // int score = reader.nextInt();
        // if (score >= 50) {
        // passCourse++;
        // totalPassScore += score;
        // }
        // }
        // double avg;
        // if (passCourse == 0) {
        // avg = 0;
        // } else {
        // avg = (double) totalPassScore / passCourse;
        // }
        // student[i] = new Student(id, name, avg);
        // }
        //
        // Arrays.sort(student, (s1, s2) -> {
        // double avgCompare = Double.compare(s2.avg, s1.avg);
        // if (avgCompare == 0) {
        // return Integer.compare(s1.id, s2.id);
        // }
        // return (int) avgCompare;
        // });

        int n = reader.nextInt();
        int k = reader.nextInt();
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
            if (passCourse == 0) {
                student.avg = 0;
            } else {
                student.avg = (double) totalPassScore / passCourse;
            }

        }

        List<Student> students = new ArrayList<>(map.values());
        students.sort((s1, s2) -> {
            double avgCompare = Double.compare(s2.avg, s1.avg);
            if (avgCompare == 0) {
                return Integer.compare(s1.id, s2.id);
            }
            return Double.compare(s2.avg, s1.avg);
        });

        int rank = 1, temp = 0;

        for (int i = 0; i < k; i++) {
            if (i > 0 && students.get(i).avg != students.get(i - 1).avg) {
                rank += temp;
                temp = 0;
            }

            sb.append(rank).append(" ").append(students.get(i).id).append(" ").append(students.get(i).name).append(" ")
                    .append((int) Math.round(students.get(i).avg)).append("\n");
            temp++;
        }

        for (int i = k; i < n; i++) {
            if (students.get(i).avg == students.get(i - 1).avg) {
                sb.append(rank).append(" ").append(students.get(i).id).append(" ").append(students.get(i).name)
                        .append(" ").append((int) Math.round(students.get(i).avg)).append("\n");
            } else {
                break;
            }
        }

        // int rank = 1, temp = 0;
        // for (int i = 0; i < k; i++) {
        // if (i > 0 && student[i].avg != student[i - 1].avg) {
        // rank += temp;
        // temp = 0;
        // }
        //
        // sb.append(rank).append(" ").append(student[i].id).append("
        // ").append(student[i].name).append(" ").append((int)
        // Math.round(student[i].avg)).append("\n");
        // temp++;
        // }
        System.out.println(sb);

    }

    static class Student {

        int id;
        String name;
        double avg;

        public Student(int id, String name) {
            this.id = id;
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
