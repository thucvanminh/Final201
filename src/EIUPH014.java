
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
public class EIUPH014 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = 1;
        int count;

        while (n != 0) {
            n = reader.nextInt();
            if (n != 0) {
                int[] arr = createArray(n);
                count = countCycles(arr);
                System.out.println(count);
            }
        }
    }

    public static int[] createArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.nextInt();
        }

        return arr;
    }

    public static int countCycles(int[] arr) {
        int count = 0, temp;

        while (checkValid(arr) == false) {
            count++;
            temp = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    arr[arr.length - 1] = Math.abs(arr[arr.length - 1] - temp);
                } else {
                    arr[i] = Math.abs(arr[i] - arr[i + 1]);
                }
            }
            if (count > 1000) {
                count = -1;
                return count;
            }
        }

        return count;
    }

    public static boolean checkValid(int[] arr) {
        boolean check = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                check = false;
                break;
            }
        }

        return check;
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
