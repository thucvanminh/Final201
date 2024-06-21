
import java.util.*;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIUONCE {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int t = reader.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            int n = reader.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = reader.nextInt();
            }

            Arrays.sort(arr);
            int count;

            for (int i = 0; i < n; i++) {
                count = 0;
                while (i + 1 < n) {
                    if (arr[i] == arr[i + 1]) {
                        count++;
                    } else {
                        break;
                    }
                    i++;
                }
                if (count == 0) {
                    sb.append(arr[i]).append(" ");
                }
            }

            sb.append("\n");
        }
        
        System.out.println(sb);
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
