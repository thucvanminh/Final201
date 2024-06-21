
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
public class EIUTHU {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        String s1 = reader.next().trim();
        String s2 = reader.next();
        boolean a = false;
        String temp1 = null, temp2 = null;
        int count;

        if (s1.length() > s2.length()) {
            a = true;
            temp1 = s1.substring(s1.length() - s2.length());
            temp2 = s2;
        } else {
            temp2 = s2.substring(0, s1.length());
            temp1 = s1;
        }

        count = countLetter(temp1, temp2);

        count = s1.length() + s2.length() - count;
        System.out.println(count);

    }

    static int countLetter(String s1, String s2) {
        String temp1, temp2;
        int x = s2.length(), count = 0;
        for (int i = 0; i < s1.length(); i++) {
            temp1 = s1.substring(i, s1.length());
            temp2 = s2.substring(0, x);
            if (temp1.equals(temp2)) {
                if (x >= count) {
                    count = x;
                }
            }
            x--;
        }

        return count;
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
