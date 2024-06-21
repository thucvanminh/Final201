import java.util.Scanner;

public class EIPOWMOD2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long result = calculateMod(a, b, c);
        System.out.println(result);
    }

    public static long calculateMod(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long temp = calculateMod(a, b / 2, c);
            return (temp * temp) % c;
        } else {
            return ((a % c) * calculateMod(a, b - 1, c)) % c;
        }
    }
}