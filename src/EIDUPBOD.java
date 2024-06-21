
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
public class EIDUPBOD {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        Map<String, Birthday> map = new HashMap<>();
        StringBuilder sb1 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int day = reader.nextInt();
            int month = reader.nextInt();
            int year = reader.nextInt();

            if (day < 10) {
                sb.append(0);
            }
            sb.append(day).append("/");
            if (month < 10) {
                sb.append(0);
            }
            sb.append(month).append("/").append(year);
            Birthday birthday = map.get(sb.toString());
            if (birthday == null) {
                birthday = new Birthday(day, month, year, sb.toString());
                map.put(birthday.dob, birthday);
            }
            birthday.count++;
        }

        List<Birthday> birthdays = new ArrayList<>(map.values());
        birthdays.sort((b1, b2)
                -> {
            int compare = b1.year - b2.year;
            if (compare == 0) {
                compare = b1.month - b2.month;
                if (compare == 0) {
                    compare = b1.day - b2.day;
                }
            }
            return compare;
        });

        for (Birthday birthday : birthdays) {
            sb1.append(birthday.dob).append(" ").append(birthday.count).append("\n");
        }
        System.out.println(sb1);
    }

    static class Birthday {

        int day;
        int month;
        int year;
        String dob;
        int count;

        public Birthday(int day, int month, int year, String dob) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dob = dob;
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
