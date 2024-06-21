import java.util.*;
import java.io.*;

class EICARDSYS {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        String id;
        double money;
        Map<String, Double> map = new HashMap<>();
        double pay = 0, dis, newMoney;

        for (int i = 0; i < n; i++) {
            id = reader.next();
            money = reader.nextDouble();
            dis = 0;
            if (map.get(id) != null) {
                dis = calculateDisc(map.get(id));
            }
            pay += money * dis;
            if (map.get(id) == null) {
                map.put(id, money);
            } else {
                newMoney = map.get(id) + money;
                map.put(id, newMoney);
            }
        }

        pay = Math.round(pay * 100);
        System.out.println(pay / 100);
    }

    static double calculateDisc(double m) {
        double mil = 1000000;
        double dis = 0;

        if (m < mil) {
            dis = 0;
        } else if (m < 20 * mil) {
            dis = 0.02;
        } else if (m < 50 * mil) {
            dis = 0.03;
        } else if (m < 200 * mil) {
            dis = 0.05;
        } else {
            dis = 0.07;
        }

        return dis;
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
