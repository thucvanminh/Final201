
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
public class EITASKDIS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] times = new int[m];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            times[i] = reader.nextInt();
        }

        Arrays.sort(times);
        reverse(times);

        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            workers.add(new Worker(i));
        }

        PriorityQueue<Worker> workerQueue = new PriorityQueue<>((w1, w2) -> {
            int workTimeCompare = Integer.compare(w1.totalWorkTime, w2.totalWorkTime);
            if (workTimeCompare == 0) {
                return Integer.compare(w1.index, w2.index);
            }
            return workTimeCompare;
        });
        workerQueue.addAll(workers);

        for (int time : times) {
            Worker minWorker = workerQueue.poll();
            minWorker.totalWorkTime += time;
            workerQueue.add(minWorker);
        }

        for (Worker worker : workers) {
            sb.append(worker.totalWorkTime).append(" ");
        }

        System.out.println(sb);
    }

    static class Worker {

        int index;
        int totalWorkTime;

        public Worker(int index) {
            this.index = index;
            this.totalWorkTime = 0;
        }
    }

    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
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
