
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
public class EIUTRANS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        int m = reader.nextInt();
        for (int i = 0; i < m; i++) {
            String a = reader.next();
            String b = reader.next();
            if (a.length() <= b.length()) {
                map.put(a, a);
            } else {
                map.put(a, b);
            }
        }

        String[] line = reader.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            sb.append(map.get(line[i])).append(" ");
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
