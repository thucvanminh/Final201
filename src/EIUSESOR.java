import java.util.Scanner;

public class EIUSESOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String dataType = scanner.next();
        Number[] arr = new Number[n];
        for (int i = 0; i < n; i++) {
            if (dataType.equals("int")) {
                arr[i] = scanner.nextInt();
            } else if (dataType.equals("long")) {
                arr[i] = scanner.nextLong();
            } else if (dataType.equals("double")) {
                arr[i] = scanner.nextDouble();
            } else if (dataType.equals("float")) {
                arr[i] = scanner.nextFloat();
            }
        }
        selectionSort(arr);
        for (Number num : arr) {
            System.out.println(num);
        }
    }

    public static void selectionSort(Number[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].doubleValue() < arr[minIndex].doubleValue()) {
                    minIndex = j;
                }
            }
            Number temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}