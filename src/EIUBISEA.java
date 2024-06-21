
import java.util.Arrays;
import java.util.Scanner;

public class EIUBISEA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // Sort the array

        for (int i = 0; i < M; i++) {
            int searchNum = scanner.nextInt();
            int result = binarySearch(arr, searchNum);
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid - 1] == target) {
                    mid--;
                }
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
