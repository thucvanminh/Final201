
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIDRAW {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int h = reader.nextInt();
        String[] arr = new String[h * 4];

        for (int i = 0; i < h; i++) {
            for (int k = 0; k < arr.length; k++) {
                if (k == i) {
                    arr[k] = "\\";
                } else if (k == h * 2 - i - 1) {
                    arr[k] = "/";
                } else if (k == h * 2 + i) {
                    arr[k] = "\\";
                } else if (k == arr.length - i - 1) {
                    arr[k] = "/";
                } else {
                    arr[k] = " ";
                }

                sb.append(arr[k]);
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
