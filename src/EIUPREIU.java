
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
public class EIUPREIU {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        String[] eiu = new String[n + 6];

        for (int i = 0; i < n + 6; i++) {
            if (i > 0 && i <= n / 2) {
                eiu[i] = "_";
            } else {
                eiu[i] = " ";
            }
            sb.append(eiu[i]);
        }
        sb.append("\n");

        for (int i = 1; i <= n; i++) {
            eiu[0] = "|";
            sb.append(eiu[0]);
            for (int j = 1; j < n + 5; j++) {
                if (i == n) {
                    if (j <= n / 2 || j > 4 + n / 2) {
                        eiu[j] = "_";
                    } else if (j == 2 + n / 2 || j == 4 + n / 2) {
                        eiu[j] = "|";
                    } else {
                        eiu[j] = " ";
                    }
                } else if (i == n / 2) {
                    if (j <= n / 2) {
                        eiu[j] = "_";
                    } else if (j == 2 + n / 2 || j == 4 + n / 2) {
                        eiu[j] = "|";
                    } else {
                        eiu[j] = " ";
                    }
                } else {
                    if (j == 2 + n / 2 || j == 4 + n / 2) {
                        eiu[j] = "|";
                    } else {
                        eiu[j] = " ";
                    }
                }
                sb.append(eiu[j]);
            }
            eiu[n + 5] = "|";
            sb.append(eiu[n + 5]);
            if (i != n) {
                sb.append("\n");
            }
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
