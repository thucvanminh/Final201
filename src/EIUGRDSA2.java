
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
class EIUGRDSA2 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt(); // Số lượng học sinh
        int p = reader.nextInt(); // Số lượng bài tập
        int m = reader.nextInt(); // Số lượng bài nộp
        Map<Integer, Student> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = reader.nextInt();
            Student student = new Student(id, p);
            if (mapA.get(id) == null) {
                mapA.put(id, student);
            }
        }

        for (int i = 0; i < p; i++) {
            int exerciseCode = reader.nextInt();
            mapB.put(exerciseCode, exerciseCode);
        }

        for (int i = 0; i < m; i++) {
            int id = reader.nextInt();
            int exerciseCode = reader.nextInt();
            int score = reader.nextInt();
            Student student = mapA.get(id);
            Integer exCode = mapB.get(exerciseCode);
            if (student != null && exCode != null) {
                student.addScore(exerciseCode, score);
            }
        }

        List<Student> students = new ArrayList<>(mapA.values());
        students.sort((s1, s2) -> {
            int avgCompare = Integer.compare((int) s2.avg, (int) s1.avg);
            if (avgCompare == 0) {
                int submitCompare = Integer.compare(s1.submit, s2.submit);
                if (submitCompare == 0) {
                    return Integer.compare(s1.id, s2.id);
                }
                return submitCompare;
            }
            return avgCompare;
        });
        
        for (Student student : students) {
            sb.append(student.id).append(" ").append((int) student.avg).append(" ").append(student.submit).append("\n");
        }

        System.out.println(sb);

    }

    static class Student {

        int id;
        int numOfExCode;
        double sum;
        double avg;
        int submit;
        Map<Integer, Integer> map = new HashMap<>();

        public Student(int id, int numOfExCode) {
            this.id = id;
            this.numOfExCode = numOfExCode;
            this.sum = 0;
            this.avg = 0;
            this.submit = 0;
        }

        public void addScore(int exerciseCode, int score) {
            int oldScore = map.getOrDefault(exerciseCode, 0);
            if (oldScore < score) {
                map.put(exerciseCode, score);
                sum += (score - oldScore);
                avg = sum / numOfExCode;
            }
            submit++;
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
