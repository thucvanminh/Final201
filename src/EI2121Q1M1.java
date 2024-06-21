
import java.io.*;
import java.util.*;

public class EI2121Q1M1 {

    public static void main(String[] args) {
        int n = ni();
//        Map<Integer, Staff> map = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            int id = ni();
            String name = ns();
            int year = 2021 - ni();
            staff[i] = new Staff(id, name, year);
        }

        Arrays.sort(staff, (s1, s2) -> {
            if (s1.year==s2.year) {
                return s1.name.compareTo(s2.name);
            }
            return Integer.compare(s2.year, s1.year);
        });

//        for (int i = 0; i < n; i++) {
//            int id = ni();
//            String name = ns();
//            int year = ni();
//            Staff staff = map.get(id);
//            if (staff == null) {
//                staff = new Staff(id, name);
//                map.put(id, staff);
//            }
//
//            staff.year = 2021 - year;
//        }
//
//        List<Staff> list = new ArrayList<>(map.values());
//        list.sort((s1, s2) -> {
//            if (s1.year == s2.year) {
//                return s1.name.compareTo(s2.name);
//            }
//            return Integer.compare(s2.year, s1.year);
//        });
        for (int i = 0; i < n; i++) {
            sb.append(staff[i].id).append(" ").append(staff[i].name).append(" ").append(staff[i].year).append("\n");
        }

        System.out.println(sb);
    }

    static class Staff {

        int id;
        String name;
        int year;

        public Staff(int id, String name, int year) {
            this.id = id;
            this.name = name;
            this.year = year;
        }
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) {
                return -1;
            }
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
