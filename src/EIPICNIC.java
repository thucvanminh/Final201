
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
public class EIPICNIC {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }

        countCar(arr);
    }

    static void countCar(int[] arr) {
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, sum = 0, t, t2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                c1++;
            } else if (arr[i] == 2) {
                c2++;
            } else if (arr[i] == 3) {
                c3++;
            } else {
                c4++;
            }
        }

        sum = c4;

        if (c3 <= c1) {
            sum += c3;
            c1 = c1 - c3;
        } else {
            sum += c1;
            c3 = c3 - c1;
            sum += c3;
            c1 = 0;
        }

        if (c2 % 2 == 0) {
            sum += c2 / 2;
            c2 = 0;
        } else {
            t = c2 / 2;
            sum += t;
            c2 = c2 - t * 2;
        }

        if ((c2 * 2 + c1) % 4 == 0) {
            t2 = (c1 + c2 * 2) / 4;
        } else {
            t2 = ((c1 + c2 * 2) / 4) + 1;
        }

        sum += t2;
        System.out.println(sum);
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
