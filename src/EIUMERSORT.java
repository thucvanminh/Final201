import java.util.Scanner;

public class EIUMERSORT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        for (int num : arr) {
            sb.append(num).append("\n");
        }
        
        System.out.println(sb);
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(arr, startIndex, mid);
            mergeSort(arr, mid + 1, endIndex);
            merge(arr, startIndex, mid, endIndex);
        }
    }

    private static void merge(int[] arr, int startIndex, int mid, int endIndex) {
        int leftLength = mid - startIndex + 1;
        int rightLength = endIndex - mid;

        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[startIndex + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = startIndex;
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}