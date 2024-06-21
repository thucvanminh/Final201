import java.util.Scanner;

public class EIAPPLEBOX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            long A = scanner.nextInt();
            long P = scanner.nextInt();

            long[] array = new long[N];
            array[0] = (long) (A * A) % P;

            for (int i = 1; i < N; i++) {
                array[i] = (array[i - 1] * A) % P;
            }

            long count = mergeSortAndCount(array, 0, N - 1);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static long mergeSortAndCount(long[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    public static long mergeAndCount(long[] arr, int l, int m, int r) {
        long[] left = new long[m - l + 1];
        long[] right = new long[r - m];
        System.arraycopy(arr, l, left, 0, m - l + 1);
        System.arraycopy(arr, m + 1, right, 0, r - m);

        long count = 0;
        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                arr[k++] = right[j++];
                count += m - (l + i) + 1;
            } else {
                arr[k++] = left[i++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        return count;
    }
}
