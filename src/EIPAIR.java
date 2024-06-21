import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EIPAIR {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        double t = reader.nextDouble();

        for (double i = 0; i < t; i++) {
            double n = reader.nextDouble();
            Map<Double, Double> map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                double num = reader.nextDouble();
                map.put(num, map.getOrDefault(num, 0.0) + 1.0);
            }

            double count = countWays(map);
            System.out.println(String.format("%.0f", count));
        }
    }

    static double countWays(Map<Double, Double> map) {
        double count = 0;

        for (double repeat : map.values()) {
                count += (repeat * (repeat - 1.0)) / 2.0;
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