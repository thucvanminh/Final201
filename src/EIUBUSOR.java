import java.util.Scanner;

public class EIUBUSOR {
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
        bubbleSort(arr);
        for (Number num : arr) {
            System.out.println(num);
        }
    }

    public static void bubbleSort(Number[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].doubleValue() > arr[j + 1].doubleValue()) {
                    Number temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}