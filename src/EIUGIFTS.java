
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIUGIFTS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = reader.nextInt();
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int dif = 0, t = 0;

        while (i < j) {
            if (arr[i] + arr[j] <= k) {
                if (arr[i] + arr[j] >= t) {
                    t = arr[i] + arr[j];
                    dif = arr[j] - arr[i];
                    if (arr[j] - arr[i] < dif) {
                        dif = arr[j] - arr[i];
                    }
                }
                i++;
            } else {
                j--;
            }
        }

        if (t != 0) {
            System.out.println(t + " " + dif);
        } else {
            System.out.println("-1 -1");
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
